import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {

        int[] correct_count = {0, 0, 0};
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        ArrayList<Integer> answer_list = new ArrayList<Integer>();
        
        for (int i = 0; i<answers.length; i++) {
        	if (first[i%first.length] == answers[i]) {
        		correct_count[0] += 1;
        	}
        	if (second[i%second.length] == answers[i]) {
        		correct_count[1] += 1;
        	}
        	if (third[i%third.length] == answers[i]) {
        		correct_count[2] += 1;
        	}
        }
        
        int maxvalue = Arrays.stream(correct_count).max().getAsInt();
        for (int i = 0; i<3; i++) {
        	if (correct_count[i] == maxvalue) 
        		answer_list.add(i+1);
        }
        
        
        int[] answer = new int[answer_list.size()];
        for (int i=0; i<answer_list.size(); i++) {
        	answer[i] = answer_list.get(i);
        }
        
        
        return answer;
    }
}
