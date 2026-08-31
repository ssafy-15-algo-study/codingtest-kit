import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int solution(int[][] jobs) {
		int answer = 0;
		int curTime = 0; // 현재 시각
		int idx = 0;
		int cnt = 0; // 처리 끝낸 작업 개수

		Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		while (cnt < jobs.length) {
			while (idx < jobs.length && jobs[idx][0] <= curTime) {
				pq.offer(jobs[idx++]);
			}

			if (!pq.isEmpty()) {
				int[] job = pq.poll();
				curTime += job[1];
				answer += curTime - job[0];
				cnt++;
			} else {
				// 작업 없으면 건너뛰기
				curTime = jobs[idx][0];
			}
		}

		return answer / jobs.length;
	}
}