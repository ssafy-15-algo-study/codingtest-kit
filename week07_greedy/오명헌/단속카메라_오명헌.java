package week7_greedy;

import java.util.Arrays;

public class 단속카메라_오명헌 {
	
	public int solution(int[][] routes) {
		
		Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int count = 0;
        int prev = -30001;
        
        for (int[] route : routes) {
        	int start = route[0];
        	int end = route[1];
        	
        	if (start > prev) {
        		count++;
        		prev = end;
        	}
        }
        
        return count;
    }
}
