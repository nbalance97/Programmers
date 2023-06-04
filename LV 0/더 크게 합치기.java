class Solution {
    public int solution(int a, int b) {
        return Math.max(
                a * (int)Math.pow(10, String.valueOf(b).length()) + b,
                b * (int)Math.pow(10, String.valueOf(a).length()) + a
        );
    }
}
