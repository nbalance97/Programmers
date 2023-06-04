import java.util.Objects;
import java.util.function.BiPredicate;

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        BiPredicate<Integer, Integer> outerPredicate;
        BiPredicate<Integer, Integer> innerPredicate;
        
        outerPredicate = ineq.equals(">") ? (a, b) -> a > b : (a, b) -> a < b;
        innerPredicate = eq.equals("=") ? Objects::equals : (a, b) -> false;
        
        return (outerPredicate.test(n, m) || innerPredicate.test(n, m)) ? 1 : 0;
    }
}
