package week2_stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;

/** [다리를 지나는 트럭]
 * Algorithm : 시뮬레이션, 큐
 * Time Complexity : O(N * K)
 * Space Complexity : O(N)
 * N <= 10,000 / K <= 10,000
 */

class 다리를_지나는_트럭_오명헌 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> bridge = new ArrayDeque<Integer>();
        for (int i = 0; i < bridge_length; i++) {
        	bridge.add(0);
        }
        
        int idx = 0;
        int time = 0;
        int bridge_weight = 0;
        
        while (bridge_weight != 0 || idx < truck_weights.length) {
        	time++;
        	
        	int value = bridge.poll();
        	bridge_weight -= value;
        	
        	if (idx < truck_weights.length && bridge_weight + truck_weights[idx] <= weight) {
        		bridge_weight += truck_weights[idx];
        		bridge.add(truck_weights[idx]);
        		idx++;
        	} else {
        		bridge.add(0);
        	}
        }
        
        return time;
    }
}