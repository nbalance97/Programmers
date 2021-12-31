import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        HashSet<Integer> reserveSet = new HashSet<Integer>(
            Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toList())
        );
        int count = 0;
        ArrayList<Integer> candidate = new ArrayList<Integer>();
        
        for (int key : lost) {
            if (!reserveSet.contains(key)) {
                candidate.add(key);
            } else {
                reserveSet.remove(key);
            }
        }
        
        for (int key : candidate) {
            if (reserveSet.contains(key - 1)) {
                reserveSet.remove(key - 1);
                count++;
                continue;
            } 
            if (reserveSet.contains(key + 1)){
                reserveSet.remove(key + 1);
                count++;
            }
        }
        
        return n - (candidate.size()-count);
    }
}
