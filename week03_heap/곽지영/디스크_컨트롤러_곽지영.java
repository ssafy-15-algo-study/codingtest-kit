import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크_컨트롤러_곽지영 {

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, ((a, b) -> Integer.compare(a[0], b[0])));

        Queue<Work> waitQ = new PriorityQueue<>();

        int idx = 0;
        int cur_ms = 0;
        int turnaround_ms = 0;

        while (idx < jobs.length || !waitQ.isEmpty()) {
            // 현재 시간 이전에 들어온 요청만 큐에 넣음
            while (idx < jobs.length && jobs[idx][0] <= cur_ms) {
                waitQ.offer(new Work(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (!waitQ.isEmpty()) {
                Work cur = waitQ.poll();

                cur_ms += cur.due_ms;
                turnaround_ms += cur_ms - cur.req_ms;
            } else
                cur_ms = jobs[idx][0];
        }

        return turnaround_ms / jobs.length;
    }

    static class Work implements Comparable<Work> {
        int idx; int req_ms; int due_ms;

        public Work(int idx, int req_ms, int due_ms) {
            this.idx = idx;
            this.req_ms = req_ms;
            this.due_ms = due_ms;
        }

        @Override
        public int compareTo(Work o) {
            if (this.due_ms == o.due_ms) {
                if (this.req_ms == o.req_ms) {
                    return Integer.compare(this.idx, o.idx);
                }
                return Integer.compare(this.req_ms, o.req_ms);
            }
            return Integer.compare(this.due_ms, o.due_ms);
        }
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        int answer = solution(jobs);

        System.out.println(answer);
    }
}
