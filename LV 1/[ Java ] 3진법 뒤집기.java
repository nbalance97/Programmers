class Solution {
    private static final int NOTATION = 3;
    public int solution(int n) {
        int answer = 0;
        int[] convertArray = new int[64];
        int size = 0;
        while (n > 0) {
            convertArray[size++] = n % NOTATION;
            n /= NOTATION;
        }
        
        for (int i = size-1; i>=0; i--) {
            answer += (convertArray[i] * Math.pow(NOTATION, size-1-i));
        }
        return answer;
    }
}
