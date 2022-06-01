import java.util.ArrayList;
import java.util.List;

class Solution {

    List<int[]> answer = new ArrayList<>();

    public void hanoi(int n, int src, int dest, int temp) {
        if (n > 0) {
            hanoi(n - 1, src, temp, dest);
            answer.add(new int[]{src, dest});
            hanoi(n - 1, temp, dest, src);
        }
    }

    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        return answer.toArray(size -> new int[0][]);
    }
}
