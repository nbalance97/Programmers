import java.util.Arrays;

class Solution {
    public int getDateByMonth(int month) {
        int day = 0;
        int[] thirtyOne = {1, 3, 5, 7, 8, 10, 12};
        for (int i = 1; i < month; i++) {
            if (i == 2) {
                day += 29;
                continue;
            }
            if (Arrays.binarySearch(thirtyOne, i) >= 0) {
                day += 31;
            } else {
                day += 30;
            }
        }
        
        return day;
    }
    
    public String solution(int a, int b) {
        String answer = "";
        String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int pos = 4;
        
        int day = getDateByMonth(a) + b - 1;
        pos = (pos + day) % 7;
        answer = week[pos];
        
        return answer;
    }
}
