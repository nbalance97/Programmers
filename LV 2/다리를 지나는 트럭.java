import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        Queue<Integer> truckQueue = new LinkedList<Integer>();
        Queue<Integer> timeQueue = new LinkedList<Integer>();
        int currentBridgeWeight = 0;
        int truckIndex = 0;
        while (truckIndex < truck_weights.length) {
            if (!truckQueue.isEmpty()) {
                if (time == timeQueue.peek()) {
                    timeQueue.poll();
                    currentBridgeWeight -= truckQueue.poll();
                }
            }
            
            if (currentBridgeWeight + truck_weights[truckIndex] <= weight) {
                currentBridgeWeight += truck_weights[truckIndex];
                truckQueue.offer(truck_weights[truckIndex++]);
                timeQueue.offer(time + bridge_length);
            }
            
            time++;
        }
        return timeQueue.stream().mapToInt(i -> i).max().getAsInt();
    }
}
