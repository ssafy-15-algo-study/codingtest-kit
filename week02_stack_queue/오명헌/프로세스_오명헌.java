package week2_stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;

/** [프로세스]
 * Idea
 * Process(번호, 우선순위) 객체를 만들어 큐에 저장한다.
 * 
 * Algorithm : 시뮬레이션, 큐
 * Time Complexity : O(N^2)
 * Space Complexity : O(N)
 */

class Process {
	int id;
	int value;
	
	public Process (int id, int value) {
		this.id = id;
		this.value = value;
	}	
}

class 프로세스_오명헌 {
    public int solution(int[] priorities, int location) {
        
        Queue<Process> q = new ArrayDeque<Process>();
        for (int i = 0; i < priorities.length; i++) {
        	Process process = new Process(i, priorities[i]);
        	q.add(process);
        }
        
        int[] orders = new int[priorities.length];
        int idx = 1;
        int max = max_q(q);
        
        while(!q.isEmpty()) {
        	Process process = q.poll();
        	
        	if (max == process.value) {
        		orders[process.id] = idx++;
        		max = max_q(q);
        	} else {
        		q.add(process);
        	}
        }
        
        return orders[location];
    }
    
    static int max_q(Queue<Process> queue) {
    	int x = -1;
    	
    	for (int i = 0; i < queue.size(); i++) {
    		Process process = queue.poll();
    		
    		x = Math.max(x, process.value);
    		queue.add(process);
    	}
    	
    	return x;
    }
}