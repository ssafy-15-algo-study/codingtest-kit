import java.util.PriorityQueue;
import java.util.Queue;

public class 더_맵게_곽지영 {

    public static int solution(int[] scoville, int K) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int scov : scoville) minHeap.offer(scov);

        int cnt = 0;

        while (minHeap.peek() < K) {
            if (minHeap.size() < 2) return -1;

            int cur = minHeap.poll();
            int next = minHeap.poll();

            minHeap.offer(cur + next * 2);
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int answer = solution(scoville, K);

        System.out.println(answer);
    }
}