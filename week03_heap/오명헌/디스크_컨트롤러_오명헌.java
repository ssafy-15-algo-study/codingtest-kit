package week3_heap;

/** [ 디스크 컨트롤러 ]
 * Algorithm : 우선순위 큐, 시뮬레이션
 * Time Complexity : O(M + N log N)
 * Space Complexity : O(N)
 * M <= 500,000 / N <= 500
 */

import java.util.Arrays;
import java.util.PriorityQueue;

class Process implements Comparable<Process> {
	int id;
	int request_time;
	int require_time;
	
	public Process(int id, int request_time, int require_time) {
		this.id = id;
		this.request_time = request_time;
		this.require_time = require_time;
	}

	@Override
	public int compareTo(Process o) {
		if (this.require_time == o.require_time) {
			if (this.request_time == o.request_time) {
				return this.id - o.id;
			}
			
			return this.request_time - o.request_time;
		}
		
		return this.require_time - o.require_time;
	}
}

class 디스크_컨트롤러_오명헌 {
    public int solution(int[][] jobs) {
    	
    	Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Process> pq = new PriorityQueue<Process>();
        
        int hardDisk = 0;
        int time = 0;
        int idx = 0;
        int answer = 0;
        
        while (idx < jobs.length || hardDisk != 0 || !pq.isEmpty()) {
        	
        	while(idx < jobs.length && jobs[idx][0] <= time) {
        		pq.add(new Process(idx, jobs[idx][0], jobs[idx][1]));
        		idx++;
        	}
        	
        	if (hardDisk == 0 && !pq.isEmpty()) {
        		Process process = pq.poll();
        		hardDisk = process.require_time;
        		answer += (time + process.require_time - process.request_time);
        	}

        	if (hardDisk != 0) hardDisk--;
        	time++;
        }
        
        return answer / jobs.length;
    }
}