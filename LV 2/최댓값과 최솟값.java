import java.util.Arrays;

class Solution {
    public int[] toInts(String[] split) {
        return Arrays.stream(split)
                .mapToInt(Integer :: parseInt)
                .toArray();
    }
    
    public int getMaxValue(int[] values) {
        return Arrays.stream(values)
                .max()
                .getAsInt();
    }

    public int getMinValue(int[] values) {
        return Arrays.stream(values)
                .min()
                .getAsInt();
    }
    
    public String solution(String s) {
        String answer = "";
        int[] intValues = toInts(s.split(" "));
        int maxValue = getMaxValue(intValues);
        int minValue = getMinValue(intValues);
        answer = makeAnswer(maxValue, minValue);
        return answer;
    }

    private String makeAnswer(int maxValue, int minValue) {
        return minValue + " " + maxValue;
    }
}
