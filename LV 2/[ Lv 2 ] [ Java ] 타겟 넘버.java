import java.util.Arrays;

class Solution {
    public int solve(int[] numbers, int sum, int target, int current_index) {
    	if (current_index >= numbers.length) {
    		if (sum == target) {
    			return 1;
    		} 
    		return 0;
    	}
    	int answer = 0;
    	answer += solve(numbers, sum+numbers[current_index], target, current_index+1);
    	answer += solve(numbers, sum-numbers[current_index], target, current_index+1);
    	return answer;
    }
	public int solution(int[] numbers, int target) {
        return solve(numbers, 0, target, 0);
    }
}
