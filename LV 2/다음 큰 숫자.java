class Solution {

    public String toBinary(int n) {
        return Integer.toBinaryString(n);
    }

    public int getOneCount(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count += 1;
            }
        }
        return count;
    }

    public int solution(int n) {
        int originalCount = getOneCount(toBinary(n));
        int current = n+1;
        while (true) {
            int oneCount = getOneCount(toBinary(current));
            if (oneCount == originalCount) {
                break;
            }
            current += 1;
        }

        return current;
    }
}
