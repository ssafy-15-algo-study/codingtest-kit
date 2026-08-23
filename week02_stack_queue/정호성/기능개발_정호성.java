import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; ++i) {
            int duringTime = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            q.offer(duringTime);
        }
        
        // 더 큰 수가 나올때마다 플러쉬
        while(!q.isEmpty()) {
            int cur = q.poll();
            int count = 1;
            
            while(!q.isEmpty()) {
                if(q.peek() <= cur) {
                    q.poll();
                    count++;
                } else {
                    break;
                }
            }
            
            answer.add(count);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}