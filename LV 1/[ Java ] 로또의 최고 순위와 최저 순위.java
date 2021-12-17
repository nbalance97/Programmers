import java.util.Arrays;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(win_nums);
        int correct_count = 0;
        int zero_count = 0;
        for (int lotto: lottos) {
            if (lotto == 0) {
                zero_count += 1;
                continue;
            }
            // 이진 탐색에서는 정렬이 선행되어야 함에 유의
            int idx = Arrays.binarySearch(win_nums, lotto);
            if (idx >= 0) {
                correct_count += 1;
            }
        }
        
        int max_rank = Math.min(7 - (correct_count+zero_count), 6);
        int min_rank = Math.min(7 - correct_count, 6);
        
        int[] answer = {max_rank, min_rank};
        
        return answer;
    }
}
