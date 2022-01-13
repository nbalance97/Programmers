class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean[1000001];
        
        for (int i = 0; i < prime.length; i++) {
            prime[i] = true;
        }
        
        prime[1] = false;
        for (int i = 2; i < 1001; i++) {
            if (prime[i]) {
                for (int j = i * 2; j < 1000001; j += i) {
                    prime[j] = false;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (prime[i]) {
                answer += 1;
            }
        }
        
        return answer;
    }
}
