class Solution {
    int MOD = 20170805;

    public void calculateRowCell(int i, int j, int[][] cityMap, int[][] dp) {
        if (cityMap[i-1][j] == 2) {
            int dest = i-2;
            while (dest >= 0 && cityMap[dest][j] == 2)
                dest -= 1;
            if (dest >= 0)
                dp[i][j] += dp[dest][j];

        } else {
            dp[i][j] += dp[i-1][j];
        }
    }

    public void calculateColCell(int i, int j, int[][] cityMap, int[][] dp) {
        if (cityMap[i][j-1] == 2) {
            int dest = j-2;
            while (dest >= 0 && cityMap[i][dest] == 2)
                dest -= 1;
            if (dest >= 0)
                dp[i][j] += dp[i][dest];
        } else {
            dp[i][j] += dp[i][j - 1];
        }
    }

    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int dp[][] = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1)
                    continue;
                if (i-1 >= 0) {
                    calculateRowCell(i, j, cityMap, dp);
                }
                if (j-1 >= 0) {
                    calculateColCell(i, j, cityMap, dp);
                }
                dp[i][j] %= MOD;
            }
        }
        answer = dp[m-1][n-1];
        return answer;
    }
}
