import java.util.Arrays;
import java.util.Collections;
class Solution
{
    public int solution(int[] A, int[] B)
    {
        int answer = 0;
        Integer[] boxedB = Arrays.stream(B).boxed().toArray(Integer[] :: new);
        Arrays.sort(A);
        Arrays.sort(boxedB, Collections.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * boxedB[i].intValue();
        }

        return answer;
    }
}
