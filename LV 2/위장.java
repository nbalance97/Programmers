import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesCount = new HashMap<>();
        Arrays.stream(clothes)
                .forEach(data -> {
                    if (!clothesCount.containsKey(data[1])) {
                        clothesCount.put(data[1], 0);
                    }
                    clothesCount.put(data[1], clothesCount.get(data[1]) + 1);
                });
        
        int combinationCount = 1;
        for (String key : clothesCount.keySet()) {
            combinationCount *= (clothesCount.get(key) + 1);
        }
        return combinationCount - 1;
    }
}
