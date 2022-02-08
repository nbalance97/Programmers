
import java.util.HashSet;
import java.util.Set;

class Line{
    int sourceX, sourceY;
    int destinationX, destinationY;

    public Line(int sourceX, int sourceY, int destinationX, int destinationY) {
        this.sourceX = sourceX;
        this.sourceY = sourceY;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }

    @Override
    public boolean equals(Object o) {
        Line target = (Line)o;
        return (sourceX == target.sourceX && sourceY == target.sourceY &&
                destinationX == target.destinationX && destinationY == target.destinationY) ||
                (sourceX == target.destinationX && sourceY == target.destinationY &&
                destinationX == target.sourceX && destinationY == target.sourceY);

    }

    @Override
    public int hashCode() {
        return 0;
    }
}

class Solution {
    Set<Line> visited = new HashSet<Line>();
    private static final int MIN = -5;
    private static final int MAX = 5;
    int x;
    int y;

    public int solution(String dirs) {
        int answer = 0;
        x = 0;
        y = 0;
        for (char command : dirs.toCharArray()) {
            answer += processCommand(command);
        }
        return answer;
    }

    private int processCommand(char command) {
        if (command == 'U') {
            return moveUp();
        }
        if (command == 'L') {
            return moveLeft();
        }
        if (command == 'R') {
            return moveRight();
        }
        if (command == 'D') {
            return moveDown();
        }
        return 0;
    }

    private int moveDown() {
        if (x == MAX) {
            return 0;
        }
        Line line = new Line(x, y, x + 1, y);
        x = x + 1;
        if (visited.contains(line)) {
            return 0;
        }
        visited.add(line);
        return 1;
    }

    private int moveRight() {
        if (y == MAX) {
            return 0;
        }

        Line line = new Line(x, y, x, y + 1);
        y = y + 1;
        if (visited.contains(line)) {
            return 0;
        }
        visited.add(line);
        return 1;
    }

    private int moveLeft() {
        if (y == MIN) {
            return 0;
        }

        Line line = new Line(x, y, x, y - 1);
        y = y - 1;
        if (visited.contains(line)) {
            return 0;
        }
        visited.add(line);
        return 1;
    }

    private int moveUp() {
        if (x == MIN) {
            return 0;
        }

        Line line = new Line(x, y, x-1, y);
        x = x - 1;
        if (visited.contains(line)) {
            return 0;
        }
        visited.add(line);
        return 1;
    }
}
