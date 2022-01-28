import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Integer> stack = new Stack<>();
        int[] targetChars = s.chars()
                .map(i -> i - '0')
                .toArray();

        for (int ch : targetChars) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
                continue;
            }
            stack.add(ch);
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
