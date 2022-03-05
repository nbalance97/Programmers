import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static final int DEFAULT_DEPTH = 0;
    public static final String REGEX = " ";
    private StringBuilder sb = new StringBuilder();

    public void push(List<String> list, List<String> currentStr, int depth) {
        if (depth == currentStr.size()) {
            list.add(sb.toString());
            return;
        }
        sb.append(currentStr.get(depth));
        push(list, currentStr, depth + 1);
        sb.delete(sb.length() - currentStr.get(depth).length(), sb.length());
        sb.append("-");
        push(list, currentStr, depth + 1);
        sb.delete(sb.length() - 1, sb.length());
    }

    public int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        Map<String, List<Integer>> mappingInformation = new HashMap<>();
        for (String eachInfo : info) {
            pushMappingInformation(mappingInformation, eachInfo);
        }

        for (String key : mappingInformation.keySet()) {
            mappingInformation.get(key).sort(Integer::compare);
        }

        for (String eachQuery : query) {
            List<String> splitQuery = Arrays.stream(eachQuery.split("( and | )")).collect(Collectors.toList());
            String key = String.join("", splitQuery.subList(0, splitQuery.size()-1));
            int value = Integer.parseInt(splitQuery.get(splitQuery.size()-1));
            List<Integer> mappingScore = mappingInformation.getOrDefault(key, Collections.<Integer>emptyList());
            int pos = Collections.binarySearch(mappingScore, value, (p1, p2) -> {
                if (p1 < p2) {
                    return -1;
                }
                return 1;
            });
            if (pos < 0) {
                pos = -pos - 1;
            }
            int count = mappingScore.size() - pos;
            answer.add(count);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private void pushMappingInformation(Map<String, List<Integer>> mappingInformation, String eachInfo) {
        List<String> list = new ArrayList<>();
        sb.setLength(0);
        List<String> splitInformation = Arrays.stream(eachInfo.split(REGEX)).collect(Collectors.toList());
        int value = Integer.parseInt(splitInformation.get(splitInformation.size() - 1));
        push(list, splitInformation.subList(0, splitInformation.size()-1), DEFAULT_DEPTH);
        for (String s : list) {
            List<Integer> data = mappingInformation.getOrDefault(s, new ArrayList<>());
            data.add(value);
            mappingInformation.put(s, data);
        }
    }
}
