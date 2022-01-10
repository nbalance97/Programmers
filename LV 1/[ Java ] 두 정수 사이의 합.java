class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int from = Math.min(a, b);
        int to = Math.max(a, b);
        
        for (int i = from; i <= to; i++) {
            answer += i;
        }
        
        return answer;
    }
}
