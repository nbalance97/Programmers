class Solution {
    public long solution(long n) {
        long answer = 0;
        long square = (long)Math.sqrt(n);
        if (square * square == n) {
            return (long)Math.pow(square+1, 2);
        }
        return -1;
    }
}
