package week4_sorting;

/** [ K번째수 ]
 * Algorithm : 정렬
 * Time Complexity : O(T * N log N)
 * Space Complexity : O(N)
 * T <= 50, N <= 100
 */

import java.util.Arrays;

class K번째수_오명헌 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answer_idx = 0;
        
        for (int[] command : commands) {
        	int start = command[0] - 1;
        	int end = command[1] - 1;
        	int k = command[2] - 1;
        	
        	int[] arr = new int[end - start + 1];
        	int arr_idx = 0;
        	
        	for (int i = start; i <= end; i++) {
        		arr[arr_idx++] = array[i];
        	}
        	
        	Arrays.sort(arr);
        	
        	answer[answer_idx++] = arr[k];
        }
        
        return answer;
    }
}