import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;
    int movement;
    public Point(int x, int y, int movement) {
        this.x = x;
        this.y = y;
        this.movement = movement;
    }

    @Override
    public boolean equals(Object o) {
        Point target = (Point)o;
        return (target.x == this.x && target.y == this.y);
    }
}

class Solution {
    
    public void pushNextPoint(Queue<Point> queue, boolean[][] visited, int[][] maps, Point currPoint) {
        int maxX = maps.length;
        int maxY = maps[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < dx.length; i++) {
            int nx = currPoint.x + dx[i]; 
            int ny = currPoint.y + dy[i];
            if (0 <= nx && nx < maxX && 0 <= ny && ny < maxY && !visited[nx][ny] && maps[nx][ny] != 0) {
                visited[nx][ny] = true;
                queue.offer(new Point(nx, ny, currPoint.movement + 1));
            }
        }
    }
    
    public int bfs(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Point lastPoint = new Point(maps.length-1, maps[0].length-1, 0);
        Queue<Point> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new Point(0, 0, 0));

        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            if (curr.equals(lastPoint)) {
                return curr.movement+1;
            }
            pushNextPoint(queue, visited, maps, curr);
        }

        return -1;
    }

    public int solution(int[][] maps) {
        return bfs(maps);
    }
}
