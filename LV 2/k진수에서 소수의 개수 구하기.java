import java.util.Arrays;

class Solution {
    public String toKDecimal(int n, int k) {
        StringBuilder builder = new StringBuilder();
        if (n == 0) {
            return "";
        }
        while (n > 0) {
            builder.append(n % k);
            n = n / k;
        }
        builder.reverse();
        return builder.toString();
    }

    public boolean isPrime(final Long n) {
        if (n < 2) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        for (long i = 2; i < (int)Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String convertKDecimal = toKDecimal(n, k);
        String[] elements = convertKDecimal.split("0+");
        for (String element : elements) {
            if (isPrime(Long.parseLong(element))) {
                answer += 1;
            }
        }
        return answer;
    }

}
