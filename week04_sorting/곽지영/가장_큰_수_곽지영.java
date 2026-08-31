import java.util.Arrays;

public class 가장_큰_수_곽지영 {

    public static String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < nums.length; i++) nums[i] = String.valueOf(numbers[i]);

        Arrays.sort(nums, (a, b) -> { return (b + a).compareTo(a + b); });

        if (nums[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String num : nums) sb.append(num);

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        String answer = solution(numbers);

        System.out.println(answer);
    }
}
