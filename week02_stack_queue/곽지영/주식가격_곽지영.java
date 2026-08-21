import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 주식가격_곽지영 {
    /*
    스택으로 푸는 법 이해가 안 가요 추후에 발전시켜서 다시 커밋하겠습니다...
     */

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;

                if (prices[i] > prices[j]) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = solution(prices);

        System.out.println(Arrays.toString(answer));
    }
}
