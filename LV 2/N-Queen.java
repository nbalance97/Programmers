class Solution {
    int answer = 0;
    int[] col = new int[12];

    public void solve(int n, int row) {
        if (row == n) {
            answer += 1;
        }

        for (int i = 0; i < n; i++) {
            boolean reachable = isReachable(row, i);

            if (!reachable) {
                continue;
            }

            col[row] = i;
            solve(n, row+1);
        }
    }

    private boolean isReachable(int row, int i) {
        boolean reachable = true;
        for (int j = 0; j < row; j++) {
            if (col[j] == i || Math.abs(col[j] - i) == Math.abs(j - row)) {
                reachable = false;
                break;
            }
        }
        return reachable;
    }

    public int solution(int n) {
        solve(n, 0);
        return answer;
    }
}
