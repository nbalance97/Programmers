class Solution {
    public String makeDigit(int n) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (n > 0) {
            if (n % 3 == 0) {
                result.insert(0, 4);
                n = n / 3;
                n--;
                continue;
            }
            result.insert(0, (n % 3));
            n = n / 3;
        }
        return result.toString();
    }

    public String solution(int n) {
        String answer = makeDigit(n);
        return answer;
    }
}
