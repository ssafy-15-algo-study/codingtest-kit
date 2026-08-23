import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        
        // 처음에는 다리 길이만큼 비어있음
        for(int i = 0; i < bridge_length; ++i) {
            q.offer(0);
        }
        
        Queue<Integer> trucks = new ArrayDeque<>();
        for(int w : truck_weights) {
            trucks.offer(w);
        }
        
        int time = 0;
        int currentLoad = 0;
        
        while(!trucks.isEmpty()) {
            time++;
            currentLoad -= q.poll();
            
            if(currentLoad + trucks.peek() <= weight) {
                int w = trucks.poll();
                
                q.offer(w);
                currentLoad += w; 
            } else {
                q.offer(0);
            }
        }
        
        answer = time + bridge_length;
        return answer;
    }
}