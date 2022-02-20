import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int yellowCol = 1; yellowCol < 2000001; yellowCol++) {
            int currentBrown = 8 + 2 * (yellowCol - 1);
            int extendCount = (brown - currentBrown) / 2;
            int yellowCellCount = yellowCol * (extendCount + 1);

            if (yellow == yellowCellCount) {
                answer[0] = Math.max(yellowCol + 2, extendCount + 3);
                answer[1] = Math.min(yellowCol + 2, extendCount + 3);
                break;
            }
        }

        return answer;
    }
}
