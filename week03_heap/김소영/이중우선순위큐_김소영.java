import java.util.*;

class Solution {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];

		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>((a, b) -> b - a);

		for (String str : operations) {
			char op = str.charAt(0);
			int num = Integer.parseInt(str.substring(2));
			if (op == 'I') {
				pq1.offer(num);
				pq2.offer(num);
			} else if (pq1.size() > 0) {
				if (num == 1) {
					int del = pq2.poll();
					pq1.remove(del);
				} else {
					int del = pq1.poll();
					pq2.remove(del);
				}
			}
		}
		
		if( pq1.size() > 0 ) {
			answer[0] = pq2.poll();
			answer[1] = pq1.poll();
		}
		
		return answer;
	}
}
