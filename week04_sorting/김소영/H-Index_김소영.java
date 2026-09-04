import java.util.Arrays;

class Solution {
	public int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);

		int n = citations.length;

		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= n - i) {
				return n - i;
			}
		}

		return answer;
	}
}