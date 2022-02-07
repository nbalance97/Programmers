import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        int time = 0;

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int removePos = stack.pop();
                answer[removePos] = time - removePos;
            }
            stack.push(i);
            time += 1;
        }

        while (!stack.isEmpty()) {
            int lastTime = prices.length - 1;
            int removePos = stack.pop();
            answer[removePos] = lastTime - removePos;
        }

        return answer;
    }
}
