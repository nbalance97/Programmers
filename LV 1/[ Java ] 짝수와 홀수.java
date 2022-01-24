class Solution {
    public String solution(int num) {
        if (num < 0) {
            num = -num;
        }
        String answer = num % 2 == 1 ? "Odd" : "Even";
        return answer;
    }
}
