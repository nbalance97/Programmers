class Solution {
    long getCharCount(String s, char c) {
        return s.chars()
                .filter(ch -> ch == c)
                .count();
    }

    boolean solution(String s) {
        boolean answer = true;
        String lower = s.toLowerCase();
        return getCharCount(lower, 'p') == getCharCount(lower, 'y');
    }
}
