import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int leastWeight = people[left];
            int greatestWeight = people[right];
            if (leastWeight + greatestWeight > limit) {
                right -= 1;
            } else {
                left += 1;
                right -= 1;
            }
            answer++;
        }

        return answer;
    }
}
