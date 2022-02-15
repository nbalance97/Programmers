import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


class Solution {

    public static final int DEFAULT_TIME = 0;
    public static final int DEFAULT_FEE = 1;
    public static final int PER_MINUTE = 2;
    public static final int FEE_PER_MINUTE = 3;
    public static final String LAST_TIME = "23:59";
    public static final int NO_PARKED_CAR_FLAG = -1;

    public int toMinute(String hour) {
        return Integer.parseInt(hour.substring(0, 2)) * 60 +
                Integer.parseInt(hour.substring(3));
    }

    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> eachCarParkTime = new HashMap<>();
        HashMap<String, Integer> currentParkedCar = new HashMap<>();

        for (String record : records) {
            calculateParkTime(eachCarParkTime, currentParkedCar, record);
        }


        int lastTime = toMinute(LAST_TIME);
        for (String carNumber : currentParkedCar.keySet()) {
            calculateRemainParkedCar(eachCarParkTime, currentParkedCar, lastTime, carNumber);
        }

        calculateFee(fees, answer, eachCarParkTime, currentParkedCar);

        return answer.stream().mapToInt(i->i).toArray();
    }

    private void calculateFee(int[] fees, List<Integer> answer, HashMap<String, Integer> eachCarParkTime,
                              HashMap<String, Integer> currentParkedCar) {
        for (String carNumber : currentParkedCar.keySet().stream().sorted().collect(Collectors.toList())) {
            int parkTime = eachCarParkTime.get(carNumber);
            if (parkTime < fees[DEFAULT_TIME]) {
                answer.add(fees[DEFAULT_FEE]);
                continue;
            }

            answer.add((int)(fees[DEFAULT_FEE] + Math.ceil((parkTime - fees[DEFAULT_TIME]) / (double) fees[PER_MINUTE])
                    * fees[FEE_PER_MINUTE]));

        }
    }

    private void calculateRemainParkedCar(HashMap<String, Integer> eachCarParkTime,
                                          HashMap<String, Integer> currentParkedCar, int lastTime, String carNumber) {
        if (currentParkedCar.get(carNumber) != NO_PARKED_CAR_FLAG) {
            int parkTime = lastTime - currentParkedCar.get(carNumber);
            eachCarParkTime.put(carNumber, Optional.ofNullable(eachCarParkTime.get(carNumber)).orElse(0)
                    + parkTime);
        }
    }

    private void calculateParkTime(HashMap<String, Integer> eachCarParkTime, HashMap<String, Integer> currentParkedCar,
                                   String record) {
        String[] splitData = record.split(" ");
        int minute = toMinute(splitData[0]);
        String carNumber = splitData[1];
        String command = splitData[2];

        if (command.equals("IN")) {
            currentParkedCar.put(carNumber, minute);
        }
        if (command.equals("OUT")) {
            int arrivedTime = currentParkedCar.get(carNumber);
            int parkTime = minute - arrivedTime;
            currentParkedCar.put(carNumber, NO_PARKED_CAR_FLAG);
            eachCarParkTime.put(carNumber, Optional.ofNullable(eachCarParkTime.get(carNumber)).orElse(0)
                    + parkTime);
        }
    }
}
