class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isFirst = true;
        for (char ch : s.toCharArray()) {
            if (ch != ' ' && isFirst) {
                answer += Character.toUpperCase(ch);
                isFirst = false;
                continue;
            }
            if (ch == ' ') {
                isFirst = true;
            }
            answer += Character.toLowerCase(ch);
        }

        return answer;
    }
}
