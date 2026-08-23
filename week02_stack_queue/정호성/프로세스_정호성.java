import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Process> q = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; ++i) {
            pq.offer(priorities[i]);
            q.offer(new Process(priorities[i], i));
        }
        
        while(!q.isEmpty()) {
            Process cur = q.poll();
            
            if(cur.priority == pq.peek()) {
                pq.poll();
                answer++;
                
                if(cur.position == location) {
                    return answer;
                }
            } else {
                q.offer(cur);
            }
        }
        
        return answer;
    }
    
    class Process {
        int priority;
        int position;
        
        Process(int priority, int position) {
            this.priority = priority;
            this.position = position;
        }
    }
}