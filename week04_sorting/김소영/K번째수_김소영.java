import java.util.Arrays;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0];
			int end = commands[i][1];

			// copyOfRange(arr, from, to)의 to는 열린구간(미포함) 
			int[] sub = Arrays.copyOfRange(array, start-1, end);
			Arrays.sort(sub);

			answer[i] = sub[commands[i][2] - 1];
		}

		return answer;
	}
}