class Solution {

    private int zeroCount = 0;
    private int oneCount = 0;

    public boolean check(int[][] arr, int sx, int ex, int sy, int ey) {
        int element = arr[sx][sy];
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                if (arr[i][j] != element) {
                    return false;
                }
            }
        }
        return true;
    }

    public void f(int[][] arr, int sx, int ex, int sy, int ey) {
        if (check(arr, sx, ex, sy, ey)) {
            int data = arr[sx][sy];
            if (data == 1) {
                oneCount += 1;
            }

            if (data == 0) {
                zeroCount += 1;
            }

            return;
        }

        int midX = (sx + ex) / 2;
        int midY = (sy + ey) / 2;
        f(arr, sx, midX, sy, midY);
        f(arr, midX + 1, ex, sy, midY);
        f(arr, sx, midX, midY + 1, ey);
        f(arr, midX + 1, ex, midY + 1, ey);

    }

    public int[] solution(int[][] arr) {
        f(arr, 0, arr.length - 1, 0, arr[0].length - 1);
        int[] answer = {zeroCount, oneCount};
        return answer;
    }

}
