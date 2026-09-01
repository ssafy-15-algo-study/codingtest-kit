package week4_sorting;

/** [ H-Index ]
 * Algorithm : 구현
 * Time Complexity : O(K * N)
 * Space Complexity : O(N)
 * K <= 10,000 / N <= 1,000
 */

class H_Index_오명헌 {

	static int min = 0;
	static int max = 10_000;
	
	public int solution(int[] citations) {
        int answer = 0;
        
        for (int i = min; i <= max; i++) {
        	int count = 0;
        	
        	for (int x : citations) {
        		if (x >= i) count++;
        	}
        	
        	if (count >= i && citations.length - count <= i) {
        		answer = Math.max(answer, i);
        	}
        }
        
        return answer;
    }
}