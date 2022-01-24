import java.util.Arrays;

class Solution {
    public int getMinValue(int[] arr) {
        return Arrays.stream(arr)
                .min()
                .getAsInt();
    }

    public int[] makeArrayExceptValue(int[] arr, int v) {
        boolean skip = true;
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] result = new int[arr.length - 1];
        int idx = 0;
        for (int element : arr) {
            if (skip && element == v) {
                skip = false;
                continue;
            }
            result[idx++] = element;
        }

        return result;
    }

    public int[] solution(int[] arr) {
        int minValue = getMinValue(arr);
        return makeArrayExceptValue(arr, minValue);
    }
}
