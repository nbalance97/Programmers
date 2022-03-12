import java.util.Arrays;

class Solution
{
    public int solution(int[][] board)
    {
        int[][] dp = new int[board.length][board[0].length];
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            answer = Math.max(answer, board[i][0]);
            dp[i][0] = board[i][0];
        }

        for (int i = 0; i < board[0].length; i++) {
            answer = Math.max(answer, board[0][i]);
            dp[0][i] = board[0][i];
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        return (int) Math.pow(answer, 2);
    }
}
