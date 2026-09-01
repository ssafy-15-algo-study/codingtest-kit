package week4_sorting;

/** [ 가장 큰 수 ]
 * Algorithm : 정렬
 * Time Complexity : O(N log N)
 * Space Complexity : O(N)
 * N <= 100,000
 */

import java.util.Arrays;

class 가장_큰_수_오명헌 {
    public String solution(int[] numbers) {
        
        String[] arr = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
        	arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        if (arr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);

        return sb.toString();
    }
}