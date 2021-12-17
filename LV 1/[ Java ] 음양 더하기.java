class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            int addValue = signs[i] == true ? absolutes[i] : -absolutes[i];
            answer += addValue;
        }
        return answer;
    }
}
