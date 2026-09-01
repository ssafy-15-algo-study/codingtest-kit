import java.util.*;

class Solution {
	public String solution(int[] numbers) {
		String answer = "";

		ArrayList<String> list = new ArrayList<String>();
		for (int n : numbers) {
			list.add(Integer.toString(n));
		}

		list.sort( (a, b) -> (a+b).compareTo(b+a));

		for (int i = list.size() - 1; i >= 0; i--) {
			answer += list.get(i);
		}

		return answer;
	}
}