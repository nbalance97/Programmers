import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point {
    int x;
    int y;
    int distance;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

class Solution {
    public char[][] convert(String[] place) {
        char[][] result = new char[5][];
        for (int i = 0; i < 5; i++) {
            result[i] = place[i].toCharArray();
        }
        return result;
    }

    public List<Point> getPlayerPoint(char[][] matrix) {
        List<Point> player = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == 'P') {
                    player.add(new Point(i, j));
                }
            }
        }
        return player;
    }

    public boolean bfs(char[][] matrix, Point player) {
        boolean[][] visited = new boolean[5][5];
        Queue<Point> queue = new LinkedList<>();
        visited[player.x][player.y] = true;
        queue.offer(new Point(player.x, player.y, 0));
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.distance == 2) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                if (0 <= nextX && nextX < 5 && 0 <= nextY && nextY < 5
                && matrix[nextX][nextY] != 'X') {
                    if (!visited[nextX][nextY]) {
                        if (matrix[nextX][nextY] == 'P')
                            return false;
                        queue.offer(new Point(nextX, nextY, current.distance+1));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

        return true;
    }


    public int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();
        for (String[] place : places) {
            char[][] convertPlace = convert(place);
            List<Point> player = getPlayerPoint(convertPlace);
            boolean result = true;
            for (Point p : player) {
                result = bfs(convertPlace, p);
                if (!result) {
                    break;
                }
            }
            if (!result) {
                answer.add(0);
            } else {
                answer.add(1);
            }
        }
        return answer.stream().mapToInt(i->i)
                .toArray();
    }
}
