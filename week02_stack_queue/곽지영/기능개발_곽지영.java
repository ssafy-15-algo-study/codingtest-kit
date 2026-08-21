import java.util.Arrays;

public class 기능개발_곽지영 {

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] ans = new int[progresses.length];
        int[] day = new int[progresses.length];
        int idx = 0; int startDay = 0;

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            // day[i] = (int) Math.ceil((double)remain / speeds[i]);

            // 정수 올림 공식 (a + b - 1) / b
            // b - 1을 더함으로써 경계에 맞게 오른쪽으로 민다.
            day[i] = (remain + speeds[i] - 1) / speeds[i];

            if (i == 0) {
                ans[idx]++;
                startDay = day[0];
            }

            if (i > 0) {
                if (startDay < day[i]) { idx++; startDay = day[i]; }
                ans[idx]++;
            }
        }

        ans = Arrays.copyOf(ans, idx + 1);
        return ans;
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] answer = solution(progresses, speeds);

        System.out.println(Arrays.toString(answer));
    }
}