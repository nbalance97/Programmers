import java.util.Optional;
import java.util.Stack;

class Solution {

    public boolean check(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.add((int)c);
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (c == ']') {
                if (stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
            if (c == '}') {
                if (stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
            if (c == ')') {
                if (stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public String rotate(String s, int count) {
        return Optional.ofNullable(s.substring(count)).orElse("")
                + Optional.ofNullable(s.substring(0, count)).orElse("");
    }

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String rotateString = rotate(s, i);
            if (check(rotateString)) {
                answer += 1;
            }
        }
        return answer;
    }
}
