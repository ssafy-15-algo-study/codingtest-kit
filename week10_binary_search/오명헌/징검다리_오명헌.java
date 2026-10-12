package week10_binary_search;

import java.util.Arrays;

/** [ 징검다리 ]
 * Idea
 * 바위를 직접 고르지 않고,
 * 거리의 최솟값을 X 이상으로 만들려면
 * 바위를 몇 개 제거해야 하는지 판단한다.
 * 
 * TimeComplexity : O(M * log N)
 * 1 <= N <= 1,000,000,000
 * 1 <= M <= 50,000
 */

class 징검다리_오명헌 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        
        while (left <= right) {
        	int mid = (left + right) / 2;
        	
        	int cnt = 0;
        	int prev = 0;
        	
        	for (int rock : rocks) {
        		// 바위 사이의 거리가 mid 보다 작으면 바위를 제거
        		if (rock - prev < mid) {
        			cnt++;
        		}
        		else {
        			prev = rock;
        		}
        	}
        	
        	if (distance - prev < mid) {
        		cnt++;
        	}
        	
        	if (cnt <= n) {
        		answer = mid;
        		left = mid + 1;
        	}
        	else {
        		right = mid - 1;
        	}
        }
        
        return answer;
    }
}