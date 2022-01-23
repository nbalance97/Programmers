class Solution {
    public String solution(String s) {
        String answer = "";
        int sequence = 0;
        for (int ascii : s.chars().toArray()) {
            int target = ascii;
            if (ascii == ' ') {
                sequence = 0;
                answer += ' ';
                continue;
            }
            else if (sequence % 2 == 1) {
                answer += (char)Character.toLowerCase(target);
            }
            else {
                answer += (char)Character.toUpperCase(target);
            }
            sequence++;
        }
        return answer;
    }
}
