import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String sorted = "" + n;
        int[] reverseArray = sorted.chars()
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(i -> i - '0')
                .toArray();
        for (int element : reverseArray) {
            answer *= 10;
            answer += element;
        }
        return answer;
    }
}
