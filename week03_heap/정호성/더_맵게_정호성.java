import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville) {
            pq.offer(i);
        }
        
        while(pq.peek() < K) {
            if(pq.size() < 2) {
                answer = -1;
                break;
            }
            int combineFood = pq.poll();
            combineFood += (pq.poll() * 2);
            
            pq.offer(combineFood);
            answer++;
        }
        
        return answer;
    }
}