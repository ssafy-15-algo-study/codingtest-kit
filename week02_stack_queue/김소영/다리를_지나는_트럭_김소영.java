import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int time = 0;
        int currentWeight = 0;
        int truckIdx = 0;

        while (truckIdx < truck_weights.length) {
            time++;
            currentWeight -= bridge.poll();

            if (currentWeight + truck_weights[truckIdx] <= weight) {
                bridge.add(truck_weights[truckIdx]);
                currentWeight += truck_weights[truckIdx];
                truckIdx++;
            } else {
                bridge.add(0);
            }
        }
        return time + bridge_length;
    }
}