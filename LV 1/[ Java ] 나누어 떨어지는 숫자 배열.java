import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] answer = {};
        
        for (int element : arr) {
            if (element % divisor == 0) {
                list.add(element);
            }
        }
        
        list.sort((a, b) -> {
            return Integer.compare(a, b);
        });
        
        answer = list.stream()
            .mapToInt(i -> i)
            .toArray();
        
        if (answer.length == 0) {
            answer = new int[]{-1};
        }
        
        return answer;
    }
}
