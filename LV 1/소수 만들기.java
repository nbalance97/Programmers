class Solution {
    public boolean determinePrimeNumber(int number) {
        if (number == 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        for (int i = 2; i<number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (determinePrimeNumber(nums[i] + nums[j] + nums[k])) {
                        answer += 1;
                    }
                }
            }
        }

        return answer;
    }
}
