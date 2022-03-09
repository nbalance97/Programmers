import java.util.ArrayList;
import java.util.List;

class Solution {
    public int getOneCount(String s) {
        return (int) s.chars()
                .filter(ch -> ch == '1')
                .count();
    }

    public String toBinaryString(int n) {
        return Integer.toBinaryString(n);
    }

    public int[] solution(String s) {
        int[] answer = {0, 0};
        String p = s;
        while (true) {
            if (p.equals("1")) {
                break;
            }
            answer[0] += 1;
            int t = getOneCount(p);
            answer[1] += (p.length() - t);
            p = toBinaryString(t);
        }
        return answer;
    }
}
