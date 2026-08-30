package week3_heap;

/** [ 더 맵게 ]
 * Algorithm : 우선순위 큐
 * Time Complexity : O(N log N)
 * Space Complexity : O(N)
 * N <= 1,000,000
 */

import java.util.PriorityQueue;

class 더_맵게_오명헌 {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for (int x : scoville) pq.add((long) x);
        
        int cnt = 0;
        
        while (!pq.isEmpty()) {
        	long min_1 = pq.poll();
        	
        	if (min_1 >= K) return cnt;
        	
        	if (!pq.isEmpty()) {
        		long min_2 = pq.poll();
        		pq.add(min_1 + min_2 * 2);
        		cnt++;
        	}
        	else return -1;
        }
        
        return -1;
    }
}