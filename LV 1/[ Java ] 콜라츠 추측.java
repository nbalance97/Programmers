class Solution {
    public int solution(int num) {
        if (num == 1)
            return 0;
        long data = num;
        for (int i = 1; i <= 500; i++) {
            data = data % 2 == 0 ? data / 2 : data * 3 + 1;
            if (data == 1)
                return i;
        }
        return -1;
    }
}
