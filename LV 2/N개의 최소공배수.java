import java.math.BigInteger;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            BigInteger element = BigInteger.valueOf(arr[i]);
            BigInteger curr = BigInteger.valueOf(answer);
            BigInteger gcd = element.gcd(curr);
            answer = element
                    .multiply(curr)
                    .divide(gcd)
                    .intValue();
        }
        return answer;
    }
}
