import java.util.Stack;

class Solution {
    public int solution(String dartResult) {
        Stack<Integer> stack = new Stack<Integer>();
        int answer = 0;
        int pos = 0;
        while (pos < dartResult.length()) {
            if (dartResult.charAt(pos) == '*') {
                Integer item1 = stack.pop();
                if (!stack.isEmpty()) {
                    stack.push(stack.pop() * 2);
                }
                stack.push(item1 * 2);
                pos += 1;
            }
            else if (dartResult.charAt(pos) == '#') {
                if (!stack.isEmpty())
                    stack.push(stack.pop() * -1);                  
                pos += 1;
            }
            else {
                int score = dartResult.charAt(pos) - '0';
                char bonus;
                if (dartResult.charAt(pos + 1) == '0') {
                    score = 10;
                    bonus = dartResult.charAt(pos + 2);
                    pos += 3;
                } else {
                    bonus = dartResult.charAt(pos + 1);
                    pos += 2;
                }
                
                int p = 0;
                if (bonus == 'S')
                    p = 1;
                if (bonus == 'D')
                    p = 2;
                if (bonus == 'T')
                    p = 3;
                
                stack.push((int)Math.pow(score, p));
            }
        }
        
        answer = stack.stream().mapToInt(i -> i).sum();
        
        return answer;
    }
}
