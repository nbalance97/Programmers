class Solution {
    public String makeStr(String s, int count) {
        if (count == 1) {
            return s;
        }
        return count + s;
    }

    public String zip(String s, int length) {
        String result = "";
        String temp = s.substring(0, length);
        int count = 1;
        for (int i = length; i < s.length(); i += length) {
            String compareTarget = s.substring(i, Math.min(i+length, s.length()));
            if (temp.equals(compareTarget)) {
                count += 1;
                continue;
            }
            result += makeStr(temp, count);
            temp = compareTarget;
            count = 1;
        }
        result += makeStr(temp, count);
        return result;
    }

    public int solution(String s) {
        int answer = 1001;
        for (int i = 1; i <= s.length() / 2 + 1; i++) {
            String result = zip(s, i);
            answer = Math.min(result.length(), answer);
        }
        return answer;
    }
}
