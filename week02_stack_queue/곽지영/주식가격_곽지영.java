import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 주식가격_곽지영 {

    public static int[] solution(int[] prices) {
        /*
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;

                if (prices[i] > prices[j]) break;
            }
        }

        return answer;
         */

        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int comp = stack.pop();
                answer[comp] = i - comp;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int n = stack.pop();
            answer[n] = prices.length - n - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = solution(prices);

        System.out.println(Arrays.toString(answer));
    }
}
