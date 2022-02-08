import java.util.Stack;

class Solution {
    int changeCount;

    public int[] toIntArray(String s) {
        return s.chars()
                .map(ch -> ch - '0')
                .toArray();
    }

    public void push(int number, int limit, Stack<Integer> stack) {
        while (!stack.isEmpty() && stack.peek() < number && changeCount < limit) {
            stack.pop();
            changeCount++;
        }
        stack.push(number);
    }

    public String makeNumber(Stack<Integer> stack, int limit) {
        int totalCount = stack.size() - (limit - changeCount);
        String s = "";
        for (int i = 0; i < totalCount; i++) {
            s += stack.get(i);
        }
        return s;
    }

    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<Integer>();
        int[] numberArray = toIntArray(number);
        changeCount = 0;
        for (int eachNumber : numberArray) {
            push(eachNumber, k, stack);
        }
        return makeNumber(stack, k);
    }
}
