import java.util.Stack;

class Solution {
    public int get_doll(int[][] board, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != 0) {
                int doll = board[i][col];
                board[i][col] = 0;
                return doll;
            } 
        }
        return -1;
    }
    
    public int push(Stack<Integer> stack, int doll) {
        if (!stack.isEmpty() && stack.peek() == doll) {
            stack.pop();
            return 2;
        }
        stack.push(doll);
        return 0;
    }
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int move : moves) {
            int doll = get_doll(board, move-1);
            if (doll != -1) {
                answer += push(stack, doll);
            }
        }
        return answer;
    }
}
