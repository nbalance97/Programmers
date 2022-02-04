class Solution {
    
    public int fibo(int n) {
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = (a + b) % 1234567;
            a = b;
            b = c;
        }
        
        return b % 1234567;
    }
    
    public int solution(int n) {
        return fibo(n);
    }
}
