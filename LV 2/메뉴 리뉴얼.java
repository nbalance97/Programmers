import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public List<String> result = new ArrayList<>();

    boolean[] visited = new boolean[10];

    public String make(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (visited[i])
                result.append(s.charAt(i));
        }
        return result.toString();
    }

    public void combination(String s, int pos, int count) {
        if (count == 0) {
            result.add(make(s));
            return;
        }
        if (pos >= s.length()) {
            return;
        }
        visited[pos] = true;
        combination(s, pos+1, count-1);
        visited[pos] = false;
        combination(s, pos+1, count);
    }


    private void addOrderCount(HashMap<String, Integer> orderCount) {
        for (String comb : result) {
            if (orderCount.containsKey(comb)) {
                orderCount.put(comb, orderCount.get(comb) + 1);
            } else {
                orderCount.put(comb, 1);
            }
        }
    }

    public void processOrder(HashMap<String, Integer> target, List<String> list, int length) {
        int maxOrder = target.keySet().stream()
                .filter(k -> k.length() == length)
                .mapToInt(k -> target.get(k))
                .max()
                .orElse(0);


        if (maxOrder < 2) {
            return;
        }

        list.addAll(
                target.keySet().stream()
                        .filter(k -> k.length() == length && target.get(k) == maxOrder)
                        .collect(Collectors.toList())
        );
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> orderCount = new HashMap<>();

        for (String order : orders) {
            order = order.chars()
                    .sorted()
                    .collect(StringBuilder :: new, StringBuilder :: appendCodePoint, StringBuilder :: append)
                    .toString();
            for (int i = 1; i <= order.length(); i++) {
                result.clear();
                combination(order, 0, i);
                addOrderCount(orderCount);
            }
        }

        for (int c : course) {
            processOrder(orderCount, answer, c);
        }

        Collections.sort(answer);

        return answer.toArray(t -> new String[t]);
    }
}
