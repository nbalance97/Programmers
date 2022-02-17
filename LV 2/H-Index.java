class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        for (int h = 0; h < 10001; h++) {
            int more = 0;
            for (int citation : citations) {
                if (citation >= h) {
                    more += 1;
                }
            }
            if (more >= h) {
                answer = Math.max(answer, h);
            }
        }
        return answer;
    }
}
