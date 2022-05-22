import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        List<Set<Long>> table = new ArrayList<>();
        table.add(new HashSet<>());
        for (int i = 1; i <= 8; i++) {
            Set<Long> numbers = new HashSet<>();
            numbers.add(Long.parseLong((""+N).repeat(i)));
            for (int j = 1; j < i; j++) {
                Set<Long> source = table.get(j);
                Set<Long> target = table.get(i-j);
                for (long sourceValue : source) {
                    for (long targetValue : target) {
                        numbers.add(sourceValue + targetValue);
                        numbers.add(sourceValue - targetValue);
                        numbers.add(sourceValue * targetValue);
                        if (targetValue != 0) {
                            numbers.add(sourceValue / targetValue);
                        }
                    }
                }
            }
            for (long num : numbers) {
               if (num == number) {
                   return i;
               }
            }
            table.add(numbers);
        }
        return -1;
    }
}
