class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for (int c : s.chars().toArray()) {
            int targetChar = c + n;
            if ('a' <= c && c <= 'z') {
                if (targetChar > 'z') {
                    targetChar -= ('z'-'a'+1);
                }
                answer += (char)targetChar;
            } 
            else if ('A' <= c && c <= 'Z') {
                if (targetChar > 'Z') {
                    targetChar -= ('Z'-'A'+1);
                }
                answer += (char)targetChar;
            }
            else {
                answer += (char)c;   
            }
        }
        return answer;
    }
}
