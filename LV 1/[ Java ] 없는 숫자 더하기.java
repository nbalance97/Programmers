import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Integer[] numberMapper = Arrays.stream(numbers)
                .boxed()
                .toArray(size -> new Integer[size]);
        Set<Integer> data = new HashSet<Integer>(Arrays.asList(numberMapper));
        for (int i = 0; i <= 9; i++) {
            if (!data.contains(i)) {
                answer += i;
            }
        }
        return answer;
    }
}
