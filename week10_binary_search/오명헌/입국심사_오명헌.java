package week10_binary_search;

/** [ 입국심사 ]
 * Idea
 * 시간 T가 주어졌을 때 n명을 다 심사할 수 있는지 판단한다.
 * 
 * TimeComplexity : O(M * logNK)
 * 1 <= M <= 100,000
 * 1 <= N <= 1,000,000,000
 * 1 <= K <= 1,000,000,000
 */

class 입국심사_오명헌 {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long minTime = Long.MAX_VALUE;
        
        for (int time : times) {
        	minTime = Math.min(minTime, time);
        }
        
        long left = 1;
        long right = minTime * n;
        answer = right;
        
        while (left <= right) {
        	long mid = (left + right) / 2;
        	long count = 0;
        	
        	for (int time : times) {
        		count += (mid / time);
        		if (count >= n) break;
        	}
        	
        	if (count >= n) {
        		answer = mid;
        		right = mid - 1;
        	}
        	else {
        		left = mid + 1;
        	}
        }
        
        return answer;
    }
}