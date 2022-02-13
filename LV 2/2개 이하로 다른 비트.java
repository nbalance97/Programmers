import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public static final int DEFAULT_VALUE = 0;
    public static final int MAX_LENGTH = 64;

    public long[] solution(long[] numbers) {
        List<Long> answer = new ArrayList<Long>();
        int[] originalBinary = new int[MAX_LENGTH];
        int[] targetBinary = new int[MAX_LENGTH];
        for (var number : numbers) {
            pushBinary(originalBinary, number);
            pushBinary(targetBinary, number + 1);
            makeTargetBinary(originalBinary, targetBinary);
            answer.add(toLongValue(targetBinary));
        }
        return answer.stream().mapToLong(i -> i).toArray();
    }

    private void makeTargetBinary(int[] originalBinary, int[] targetBinary) {
        int differCount = getDifferCount(originalBinary, targetBinary);
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (differCount <= 2) {
                break;
            }
            if (originalBinary[i] != targetBinary[i]) {
                targetBinary[i] = originalBinary[i];
                differCount -= 1;
            }
        }
    }

    private Long toLongValue(int[] targetBinary) {
        Long result = 0l;
        for (int i = 0; i < MAX_LENGTH; i++) {
            result += (targetBinary[i] * ((long)Math.pow(2, i)));
        }

        return result;
    }

    private int getDifferCount(int[] originalBinary, int[] targetBinary) {
        return (int) IntStream.range(0, originalBinary.length)
                .filter(i -> originalBinary[i] != targetBinary[i])
                .count();

    }

    private void pushBinary(int[] originalBinary, long number) {
        int index = 0;
        Arrays.fill(originalBinary, DEFAULT_VALUE);
        while (number != 0) {
            originalBinary[index++] = (int)(number % 2);
            number = number / 2;
        }
    }
}
