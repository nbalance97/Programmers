import java.math.BigInteger;

class Solution {
    public int[] solution(int n, int m) {
        BigInteger nb = BigInteger.valueOf(n);
        BigInteger mb = BigInteger.valueOf(m);

        BigInteger gcd = nb.gcd(mb);
        BigInteger lcm = nb.multiply(mb).divide(gcd);

        int[] answer = {gcd.intValue(), lcm.intValue()};
        return answer;
    }
}
