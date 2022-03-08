import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int[][] matrix = new int[1001][1001];
        int movementCount = n;
        int x = -1, y = 0;
        int number = 1;
        while (true) {
            for (int i = 0; i < movementCount; i++) {
                matrix[++x][y] = number++;
            }
            movementCount--;
            for (int i = 0; i < movementCount; i++) {
                matrix[x][++y] = number++;
            }
            movementCount--;
            for (int i = 0; i < movementCount; i++) {
                matrix[--x][--y] = number++;
            }
            movementCount--;
            if (movementCount < 0) {
                break;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer.add(matrix[i][j]);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
