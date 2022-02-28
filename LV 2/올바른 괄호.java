class Solution {

    boolean solution(String s) {
        int closeCount = 0;
        for (char c : s.toCharArray()) {
            closeCount = getNextCloseCount(closeCount, c);
            if (closeCount == -1) {
                return false;
            }
        }

        if (closeCount != 0) {
            return false;
        }

        return true;
    }

    private int getNextCloseCount(int closeCount, char c) {
        if (c == ')') {
            return closeCount - 1;
        }
        return closeCount + 1;
    }
}
