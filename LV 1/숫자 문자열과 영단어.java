class Solution {
    public int solution(String s) {
        int answer = 0;
        String targetNumber = s;
        String[] targetString = {"zero", "one", "two", "three", "four", "five", "six", "seven",
                              "eight", "nine"};
        String[] replaceString = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        
        for (int i = 0; i<targetString.length; i++) {
            targetNumber = targetNumber.replace(targetString[i], replaceString[i]);
        }
        
        answer = Integer.parseInt(targetNumber);
        return answer;
    }
}
