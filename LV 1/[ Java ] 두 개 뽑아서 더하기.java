import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>(set);
        answer = list.stream()
            .sorted()
            .mapToInt(e -> e.intValue())
            .toArray();
        
        
        return answer;
    }
}
