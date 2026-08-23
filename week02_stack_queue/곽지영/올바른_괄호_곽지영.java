import java.util.Stack;

public class 올바른_괄호_곽지영 {

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean answer = solution(")()(");

        System.out.println(answer);
    }
}
