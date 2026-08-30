package week3_heap;

/** [이중우선순위큐]
 * Idea
 * - N이 최대 1,000,000 이므로 remove 함수를 쓰지 않고, 상태관리 배열을 만들어 관리한다.
 * 
 * Algorithm : 우선순위 큐
 * Time Complexity : O(N log N)
 * Space Complexity : O(N)
 * N <= 1,000,000
 */

import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int id;
	int value;
	
	public Node (int id, int value) {
		this.id = id;
		this.value = value;
	}
}

class 이중우선순위큐_오명헌 {
	
	static int MAX_N = 1_000_000;
	static boolean[] status;
	
    public int[] solution(String[] operations) {
        
        status = new boolean[MAX_N + 1];
        
        PriorityQueue<Node> min_pq = new PriorityQueue<Node>((o1, o2) -> o1.value - o2.value);
        PriorityQueue<Node> max_pq = new PriorityQueue<Node>((o1, o2) -> o2.value - o1.value);
        
        int idx = 0;
        
        for (String operation : operations) {
        	StringTokenizer st = new StringTokenizer(operation);
        	
        	String command = st.nextToken();
        	int num = Integer.parseInt(st.nextToken());
        	
        	if (command.equals("I")) {
        		min_pq.add(new Node(idx, num));
        		max_pq.add(new Node(idx, num));
        		status[idx] = true;
        		idx++;
        	}
        	else {
        		if (num < 0) {
        			while (!min_pq.isEmpty()) {
        				Node node = min_pq.poll();
        				
        				if (status[node.id]) {
        					status[node.id] = false;
        					break;
        				}
        			}
        		}
        		else {
        			while (!max_pq.isEmpty()) {
        				Node node = max_pq.poll();
        				
        				if (status[node.id]) {
        					status[node.id] = false;
        					break;
        				}
        			}
        		}
        	}
        }
        
        int min = 0;
        int max = 0;
        
        while (!min_pq.isEmpty()) {
        	Node node = min_pq.poll();
        	
        	if (status[node.id]) {
        		min = node.value;
        		break;
        	}
        }
        
        while (!max_pq.isEmpty()) {
        	Node node = max_pq.poll();
        	
        	if (status[node.id]) {
        		max = node.value;
        		break;
        	}
        }
        
        int[] answer = new int[2];
        
        answer[0] = max;
        answer[1] = min;
        
        return answer;
    }
}