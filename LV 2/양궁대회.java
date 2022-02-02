import java.util.Arrays;
import java.util.Optional;

class Solution {

    int[] lion = new int[11];
    int[] apeach;
    int diff = 0;
    int currdiff = 0;
    int[] answer = null;

    public boolean compare() {
        int apeachScore = 0;
        int lionScore = 0;
        for (int i = 0; i < 11; i++) {
            if (apeach[i] < lion[i]) {
                lionScore += (10 - i);
            } else {
                if (apeach[i] != 0) {
                    apeachScore += (10 - i);
                }
            }
        }
        diff = Math.abs(lionScore - apeachScore);
        return lionScore > apeachScore;
    }

    public void solve(int pos, int remainder) {
        if (pos < 0 && remainder > 0) {
            return;
        }

        if (remainder == 0) {
            if (compare()) {
                if (diff > currdiff) {
                    currdiff = diff;
                    answer = Arrays.copyOf(lion, 11);
                }
            }
            return;
        }

        for (int i = remainder; i >= 0; i--) {
            lion[pos] = i;
            solve(pos-1, remainder-i);
            lion[pos] = 0;
        }

        lion[pos] = 0;
    }

    public int[] solution(int n, int[] info) {
        int[] fail = {-1};
        apeach = info;
        solve(10, n);
        return Optional.ofNullable(answer).orElse(fail);
    }
}
