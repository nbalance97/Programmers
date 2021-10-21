import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for (int score:scoville) {
        	heap.add(score);
        }
        
        int shuffle_count = 0;
        while(heap.size() > 1) {
        	if (heap.peek() >= K) {
        		break;
        	}
        	
        	int e1 = heap.remove();
        	int e2 = heap.remove();
        	int new_score = e1 + e2 * 2;
        	shuffle_count += 1;
        	heap.add(new_score);
        }
        
        if (heap.peek() >= K) {
        	return shuffle_count;
        } else {
        	return -1;
        }
    }
}
