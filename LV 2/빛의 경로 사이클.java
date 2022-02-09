import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};

    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<Integer>();
        boolean[][][] visited = new boolean[grid.length][grid[0].length()][4];
        char[][] matrix = Arrays.stream(grid)
                .map(s -> s.toCharArray())
                .toArray(s -> new char[s][]);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visited[i][j][k]) {
                        answer.add(go(visited, matrix, i, j, k));
                    }
                }
            }
        }

        return answer.stream()
                .mapToInt(i -> i)
                .sorted()
                .toArray();
    }

    private int go(boolean[][][] visited, char[][] matrix, int x, int y, int way) {
        int count = 0;

        while (!visited[x][y][way]) {
            visited[x][y][way] = true;
            count++;
            if (matrix[x][y] == 'L' || matrix[x][y] == 'R') {
                way = nextWay(matrix, x, y, way);
            }
            x = x + dx[way];
            y = y + dy[way];
            if (x >= matrix.length) {
                x = 0;
            }
            if (x < 0) {
                x = matrix.length - 1;
            }
            if (y >= matrix[0].length) {
                y = 0;
            }
            if (y < 0) {
                y = matrix[0].length - 1;
            }
        }
        return count;
    }

    private int nextWay(char[][] matrix, int x, int y, int way) {
        if (matrix[x][y] == 'L') {
            way = way - 1;
            if (way == -1) {
                way = 3;
            }
        }
        if (matrix[x][y] == 'R') {
            way = way + 1;
            if (way == 4) {
                way = 0;
            }
        }
        return way;
    }
}
