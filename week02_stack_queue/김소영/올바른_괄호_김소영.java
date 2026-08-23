import java.util.ArrayDeque;

class Solution {
	boolean solution(String s) {
		boolean answer = true;

		ArrayDeque<String> q = new ArrayDeque<String>();
		for (int i = 0; i < s.length(); i++) {
			if ('(' == s.charAt(i)) {
				q.push("(");
			} else {
				if (q.isEmpty()) {
					answer = false;
					break;
				} else {
					q.pop();
				}
			}
		}
		if (q.isEmpty())
			return answer;
		else
			return false;
	}
}