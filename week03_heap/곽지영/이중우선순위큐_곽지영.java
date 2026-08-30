import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐_곽지영 {
    public static int[] solution(String[] operations) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (String operation : operations) {
            String[] o = operation.split(" ");
            String op = o[0]; int val = Integer.parseInt(o[1]);

            if (op.equals("I")) {
                maxHeap.offer(val);
                minHeap.offer(val);
            }

            if (op.equals("D")) {
                if (maxHeap.isEmpty() || minHeap.isEmpty()) continue;

                if (val == -1) {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                } else {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                }
            }
        }

        if (maxHeap.isEmpty() || minHeap.isEmpty())
            return new int[] {0, 0};

        return new int[] {maxHeap.peek(), minHeap.peek()};
    }

    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = solution(operations);

        System.out.println(Arrays.toString(answer));
    }
}