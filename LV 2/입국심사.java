class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = 10000000000000L;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }
            if (sum >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
