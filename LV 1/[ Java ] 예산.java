import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int price : d) {
            budget -= price;
            if (budget >= 0) {
                answer += 1;
            } else {
                break;
            }
        }
        return answer;
    }
}
