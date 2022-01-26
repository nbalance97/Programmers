class Solution {
    public boolean solution(int x) {
        boolean answer = x % ((""+x).chars()
                .map(i -> i - '0')
                .sum()) == 0;
        return answer;
    }
}
