import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Task> pqjobs = new PriorityQueue<>((a, b) ->
            Integer.compare(a.reqTime, b.reqTime)
        );
        
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            if(a.durTime != b.durTime) return Integer.compare(a.durTime, b.durTime);
            if(a.reqTime != b.reqTime) return Integer.compare(a.reqTime, b.reqTime);
            
            return Integer.compare(a.num, b.num);
        });
        
        for(int i = 0; i < jobs.length; ++i) {
                pqjobs.offer(new Task(i, jobs[i][0], jobs[i][1]));
        }
        
        int time = 0;
        
        while(!pqjobs.isEmpty() || !pq.isEmpty()) {
            while(!pqjobs.isEmpty() && pqjobs.peek().reqTime <= time) {
                pq.offer(pqjobs.poll());
            }

            
            if(pq.isEmpty()) {
                time = pqjobs.peek().reqTime;
            } else {
                Task cur = pq.poll();
                
                time += cur.durTime;
                
                answer += time - cur.reqTime;
            }
            
        }
        
        
        return answer / jobs.length;
    }
    
    class Task {
        int num;
        int reqTime; // s
        int durTime; // l
        
        Task(int num, int reqTime, int durTime) {
            this.num = num;
            this.reqTime = reqTime;
            this.durTime = durTime;
        }
    }
}