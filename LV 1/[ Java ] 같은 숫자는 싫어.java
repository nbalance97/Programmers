import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int element : arr) {
            if (list.isEmpty() || list.get(list.size() - 1) != element) {
                list.add(element);
            }
        }
        
        answer = list.stream()
            .mapToInt(i -> i)
            .toArray();
        
        return answer;
    }
}
