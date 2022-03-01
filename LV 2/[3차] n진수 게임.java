class Solution {
    String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public String makeNumber(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50001; i++) {
            sb.append(toStr(i, n));
        }
        return sb.toString();
    }

    private String toStr(int i, int n) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            return "0";
        }
        while (i != 0) {
            sb.append(nums[i % n]);
            i = i / n;
        }

        return sb.reverse().toString();
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        String maked = makeNumber(n);
        for (int i = 0; i < t; i++) {
            answer.append(maked.charAt(i * m + (p-1)));
        }
        return answer.toString();
    }
}
