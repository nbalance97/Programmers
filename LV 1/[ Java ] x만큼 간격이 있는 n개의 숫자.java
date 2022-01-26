import java.util.ArrayList;
import java.util.List;

public class Solution {
    public long[] solution(int x, int n) {
        List<Long> list = new ArrayList<>();
        for (long i = 0; i < n; i++) {
            list.add(x + x * i);
        }
        return list.stream()
                .mapToLong(l -> l)
                .toArray();
    }
}
