class Solution {
    public String solution(String s) {
        int middle = s.length() / 2;
        if (s.length() % 2 == 0) {
            return s.substring(middle-1, middle+1);
        }      
        return s.substring(middle, middle+1);
    }
}
