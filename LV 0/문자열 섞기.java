class Solution {

    public String solution(String str1, String str2) {
        StringBuilder answer = new StringBuilder();
        var aidx = 0;
        var bidx = 0;
        var flg = true;
        while (aidx != str1.length() || bidx != str2.length()) {
            if (flg && aidx < str1.length()) {
                answer.append(str1.charAt(aidx++));
            } else if (bidx < str2.length()) {
                answer.append(str2.charAt(bidx++));
            }

            flg = !flg;
        }

        return answer.toString();
    }
}
