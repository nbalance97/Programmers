import java.util.Queue;
import java.util.LinkedList;

class Position {
    int x;
    int y;
    
    public Position(int a, int b) {
        this.x = a;
        this.y = b;
    }
}

class Solution {
    public int bfs(int curX, int curY, int[][] picture) {
        Queue<Position> queue = new LinkedList<Position>();
        int areaValue = picture[curX][curY];
        queue.add(new Position(curX, curY));
        picture[curX][curY] = 0;
        int count = 1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            for (int i = 0; i<4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if (0 <= nx && nx < picture.length && 
                    0 <= ny && ny < picture[0].length && 
                    picture[nx][ny] == areaValue) {
                    queue.add(new Position(nx, ny));
                    count++;
                    picture[nx][ny] = 0;
                }
            }
        }
        
        return count;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        int[][] copypicture = new int[picture.length][picture[0].length];
        
        for (int i = 0; i<m; i++)
            for (int j=0; j<n; j++)
                copypicture[i][j] = picture[i][j];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (copypicture[i][j] != 0) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, copypicture));
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
