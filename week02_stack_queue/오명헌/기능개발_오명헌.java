package week2_stack_queue;

import java.util.ArrayList;
import java.util.List;

/** [ 기능개발 ]
 * Algorithm : 시뮬레이션
 * Time Complexity : O(NK)
 * Space Complexity : O(N)
 */

class 기능개발_오명헌 {
    public int[] solution(int[] progresses, int[] speeds) {

    	int[] releases = new int[progresses.length];
        
        int day = 0;
        
        for (int i = 0; i < progresses.length; i++) {
        	
        	while (progresses[i] + speeds[i] * day < 100) {
        		day++;
        	}
        	
        	releases[i] = day;
        }
        
        List<Integer> answer_list = new ArrayList<Integer>();
        int prev = releases[0];
        int count = 1;
        
        for (int i = 1; i < releases.length; i++) {
        	
        	if (prev != releases[i]) {
        		answer_list.add(count);
        		count = 0;
        	}
        	
        	count++;
        	prev = releases[i];
        }
        
        answer_list.add(count);
        
        int[] answer = new int[answer_list.size()];
        
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = answer_list.get(i);
        }
        
        return answer;
    }
}