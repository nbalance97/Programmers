import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class Solution {

    public int getBalancedPos(String s) {
        int openCount = 0;
        int closeCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            }
            if (s.charAt(i) == ')') {
                closeCount++;
            }
            if (openCount == closeCount) {
                return i;
            }
        }
        return s.length();
    }

    public boolean check(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty())
                    return false;
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }

        return stack.isEmpty();
    }

    public String reverse(String s) {
        return s.chars()
                .map(c -> c == '(' ? ')' : '(')
                .collect(StringBuilder :: new, StringBuilder :: appendCodePoint, StringBuilder :: append)
                .toString();

    }

    public String subStr(String s, int f, int t) {
        try {
            return s.substring(f, t);
        } catch (Exception e) {
            return "";
        }
    }

    public String solve(String s) {
        if (s == "") {
            return "";
        }

        int pos = getBalancedPos(s);
        String u = subStr(s, 0, pos+1);
        String v = subStr(s, pos+1, s.length());

        if (check(u)) {
            return u + solve(v);
        }

        return "(" + solve(v) + ")" + reverse(subStr(u, 1, u.length()-1));
    }

    public String solution(String p) {
        String answer = solve(p);
        return answer;
    }
}
