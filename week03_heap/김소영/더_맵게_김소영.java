import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i : scoville) {
			pq.offer(i);
		}

		while (pq.size() > 1 && pq.peek() < K) {
			++answer;
			int a = pq.poll();
			int b = pq.poll();
			pq.offer(a + b * 2);
		}

		return pq.peek() < K ? -1 : answer;
	}
}