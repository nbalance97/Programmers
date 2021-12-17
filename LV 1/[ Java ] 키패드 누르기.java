class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void copy(Point p) {
        this.x = p.x;
        this.y = p.y;
    }
}

class Solution {
    public int get_distance(Point p1, Point p2) {
        return Math.abs(p2.x - p1.x) + Math.abs(p2.y - p1.y);
    }
    
    public Point get_point(int number) {
        if (number == 0) {
            return new Point(4, 2);
        }
        return new Point((number-1) / 3 + 1, (number - 1) % 3 + 1);
    }
    
    public void process_middle_column(int number, Point leftPos, Point rightPos, StringBuilder answer, boolean isLeft) {
        Point targetPoint = get_point(number);
        int left_distance = get_distance(targetPoint, leftPos);
        int right_distance = get_distance(targetPoint, rightPos);
        if (left_distance > right_distance) {
            rightPos.copy(targetPoint);
            answer.append("R");
        }
        if (left_distance < right_distance) {
            leftPos.copy(targetPoint);
            answer.append("L");
        }
        if (left_distance == right_distance) {
            if (isLeft) {
                answer.append("L");
                leftPos.copy(targetPoint);
                return;
            }
            answer.append("R");
            rightPos.copy(targetPoint);
        }
    }
    
    public void process(int number, Point leftPos, Point rightPos, StringBuilder answer, boolean isLeft) {
        Point targetPoint = get_point(number);
        if (targetPoint.y == 1) {
            leftPos.copy(targetPoint);
            answer.append("L");
            return;
        }
        if (targetPoint.y == 3) {
            rightPos.copy(targetPoint);
            answer.append("R");
            return;
        }
        process_middle_column(number, leftPos, rightPos, answer, isLeft);
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        boolean isLeft = hand.equals("left");
        Point leftPos = new Point(4, 1);
        Point rightPos = new Point(4, 3);
        for (int number : numbers) {
            process(number, leftPos, rightPos, answer, isLeft);
        }
        return new String(answer);
    }
}
