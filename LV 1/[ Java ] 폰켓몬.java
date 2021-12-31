import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        int length = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toSet()).size();
        return Math.min(nums.length / 2, length);
    }
}
