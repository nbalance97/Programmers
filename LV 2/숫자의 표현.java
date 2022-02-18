class Solution {
    public int solution(int n) {
        int answer = 0;
        int left = 0;
        int right = 0;
        int currentSum = 0;
        while (left <= right) {
            if (currentSum == n) {
                answer++;
            }

            if (currentSum <= n) {
                right++;
                currentSum += right;
            } else {
                currentSum -= left;
                left++;
            }
        }
        return answer;
    }
}
