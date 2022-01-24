import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(long n) {
        List<Integer> charList = Long.toString(n).chars()
                .boxed()
                .collect(Collectors.toList());

        Collections.reverse(charList);

        int[] answer = charList.stream()
                .mapToInt(i -> i-'0')
                .toArray();

        return answer;
    }
}
