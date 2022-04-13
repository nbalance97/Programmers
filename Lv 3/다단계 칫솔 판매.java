import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        int[] answer = new int[enroll.length];

        Map<String, Integer> profit = Arrays.stream(enroll)
                .collect(Collectors.toMap(s -> s, i -> 0));
        Map<String, String> parent = new HashMap<>();

        for (int i = 0; i < referral.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            int sellPrice = 100 * amount[i];
            profit.put(seller[i], profit.get(seller[i]) + sellPrice);
            String userName = seller[i];
            while(!userName.equals("-")) {
                sellPrice = sellPrice / 10;
                if (sellPrice == 0) {
                    break;
                }
                profit.put(userName, profit.get(userName) - sellPrice);
                userName = parent.get(userName);
                if (!userName.equals("-")) {
                    profit.put(userName, profit.get(userName) + sellPrice);
                }
            }
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profit.get(enroll[i]);
        }

        return answer;
    }
}
