import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 같은_숫자는_싫어_곽지영 {

    public static int[] solution(int[] arr) {
        List<Integer> ansList = new ArrayList<>();

        for (int num : arr) {
            if (ansList.isEmpty() || !ansList.get(ansList.size() - 1).equals(num))
                ansList.add(num);
        }

        int[] ans = new int[ansList.size()];

        for (int i = 0; i < ans.length; i++) ans[i] = ansList.get(i);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] answer = solution(arr);

        System.out.println(Arrays.toString(answer));
    }
}