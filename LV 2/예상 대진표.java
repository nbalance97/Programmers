class Solution
{
    public boolean checkSameGroup(int a, int b) {
        int aGroup = a / 2, bGroup = b / 2;
        if (a % 2 == 1) {
            aGroup++;
        }
        if (b % 2 == 1) {
            bGroup++;
        }
        return aGroup == bGroup;
    }

    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while (true) {
            if (checkSameGroup(a, b)) {
                break;
            }
            int add = 0;
            if (a % 2 == 1) {
                add = 1;
            }
            a = a / 2;
            a += add;

            add = 0;
            if (b % 2 == 1) {
                add = 1;
            }
            b = b / 2;
            b += add;
            
            answer += 1;
        }
        return answer;
    }
}
