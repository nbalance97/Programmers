import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public int[] targetArray;
    public Set<Integer> makedIntValue = new HashSet<>();
    public boolean[] visited;

    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        for (int i = 2; i <= (int)Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int makeIntValue(int[] targetArray, int maxStep) {
        int value = 0;
        for (int i = 0; i < maxStep; i++) {
            value *= 10;
            value += targetArray[i];
        }

        return value;
    }

    public int solve(int[] array, int step, int maxStep) {
        if (step == maxStep) {
            int result = makeIntValue(targetArray, maxStep);
            if (makedIntValue.contains(result)) {
                return 0;
            }
            makedIntValue.add(result);

            if (isPrime(result)) {
                return 1;
            }
        }

        int answer = 0;
        for (int i = 0; i<array.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                targetArray[step] = array[i];
                answer += solve(array, step+1, maxStep);
                visited[i] = false;
            }
        }

        return answer;
    }

    public int solution(String numbers) {
        int[] convertNumberArray = numbers.chars()
                .map(i -> i - '0')
                .toArray();
        int answer = 0;
        targetArray = new int[convertNumberArray.length];
        visited = new boolean[convertNumberArray.length];
        for (int elementCount = 1; elementCount <= convertNumberArray.length; elementCount++) {
            answer += solve(convertNumberArray, 0, elementCount);
        }
        return answer;
    }
}
