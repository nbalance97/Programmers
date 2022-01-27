import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        List<String> convertList = new ArrayList<>();
        Map<String, String> idNicknameMap = new HashMap<>();

        for (String log : record) {
            String[] data = log.split(" ");
            if (data[0].equals("Enter") || data[0].equals("Change")) {
                idNicknameMap.put(data[1], data[2]);
            }
        }

        for (String log : record) {
            String[] data = log.split(" ");
            if (data[0].equals("Enter")) {
                convertList.add(String.format("%s님이 들어왔습니다.", idNicknameMap.get(data[1])));
            }
            if (data[0].equals("Leave")) {
                convertList.add(String.format("%s님이 나갔습니다.", idNicknameMap.get(data[1])));
            }
        }
        return convertList.stream()
                .toArray(i -> new String[i]);
    }
}
