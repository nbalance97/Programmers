import java.util.Comparator;

class Solution {
    public String solution(String s) {
        String answer = "";

        int[] temp = s.chars()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();
        
        for (int ch : temp) {
            answer += (char)ch;
        }
        return answer;
    }
}
