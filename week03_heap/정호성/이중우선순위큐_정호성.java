import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        int count = 0;
        
        StringTokenizer st;
        
        PriorityQueue<NI> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.num, a.num));
        PriorityQueue<NI> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.num, b.num));
        
        for(String s : operations) {
            st = new StringTokenizer(s);
            
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            while(!maxHeap.isEmpty() && !maxHeap.peek().valid) {
                maxHeap.poll();
            }
            while(!minHeap.isEmpty() && !minHeap.peek().valid) {
                minHeap.poll();
            }
            
            if(command.equals("I")) {
                NI cur = new NI(num);
                maxHeap.offer(cur);
                minHeap.offer(cur);
                count++;
            } else if(command.equals("D")) {
                if(num > 0) {
                    if(!maxHeap.isEmpty()) {
                        maxHeap.poll().valid = false;
                        count--;
                    }
                    
                } else {
                    if(!minHeap.isEmpty()) {
                        minHeap.poll().valid = false;
                        count--;
                    }
                    
                }
            }
            while(!maxHeap.isEmpty() && !maxHeap.peek().valid) {
                maxHeap.poll();
            }
            while(!minHeap.isEmpty() && !minHeap.peek().valid) {
                minHeap.poll();
            }
        }
        
        if(count > 0) {
            answer[0] = maxHeap.peek().num;
            answer[1] = minHeap.peek().num;
        }
        
        
        return answer;
    }
    
    class NI {
        int num;
        boolean valid;
        
        NI(int num) {
            this.num = num;
            valid = true;
        }
    }
}