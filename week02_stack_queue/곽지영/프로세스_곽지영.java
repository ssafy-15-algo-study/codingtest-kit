import java.util.*;

public class 프로세스_곽지영 {

    static class Process {
        int priority; int idx;

        public Process(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }

    public static int solution(int[] priorities, int location) {
        Queue<Process> q = new ArrayDeque<>();
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(priorities[i], i));
            pq.offer(priorities[i]);
        }

        int cnt = 0;

        while (!q.isEmpty()) {
            Process cur = q.poll();

            if (cur.priority == pq.peek()) {
                cnt++;
                pq.poll();

                if (cur.idx == location) return cnt;
            } else {
                q.offer(cur);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int answer = solution(priorities, location);

        System.out.println(answer);
    }
}