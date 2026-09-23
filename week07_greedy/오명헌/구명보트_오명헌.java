package week7_greedy;

import java.util.Arrays;

public class 구명보트_오명헌 {
	
	public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int cnt = 0;
        
        while (left <= right) {
        	
        	int heavy = people[right];
        	int light = people[left];
        	
        	cnt++;
        	
        	if (heavy + light <= limit) {
        		right--;
        		left++;
        	}
        	else {
        		right--;
        	}
        }
        
        return cnt;
    }
}
