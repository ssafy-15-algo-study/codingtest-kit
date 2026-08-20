package week2_stack_queue;

/** [ 같은 숫자는 싫어 ]
 * Idea
 * 1. 큐에 arr을 하나씩 넣는다.
 * 2. 넣을 때 이전 값과 같으면 넣지 않는다.
 * 3. 큐를 앞에서 부터 배열에 담아 반환한다.
 * 
 * Algorithm : 큐
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */

import java.util.*;

public class 같은_숫자는_싫어_오명헌 {
	
    public int[] solution(int []arr) {

    	Queue<Integer> q = new ArrayDeque<Integer>();
        int prev = -1;
        
        for (int now : arr) {
        	if (prev != now) q.add(now);
        	prev = now;
        }
        
        int[] answer = new int[q.size()];
        
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = q.poll();
        }

        return answer;
    }
}