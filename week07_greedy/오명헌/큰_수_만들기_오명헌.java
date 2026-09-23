package week7_greedy;

import java.util.ArrayDeque;
import java.util.Deque;

public class 큰_수_만들기_오명헌 {
	
	public String solution(String number, int k) {
	    Deque<Character> dq = new ArrayDeque<>();

	    for (int i = 0; i < number.length(); i++) {
	        char now = number.charAt(i);

	        while (k > 0 && !dq.isEmpty() && dq.peekLast() < now) {
	            dq.pollLast();
	            k--;
	        }

	        dq.addLast(now);
	    }

	    while (k-- > 0) dq.pollLast();

	    StringBuilder sb = new StringBuilder();
	    while (!dq.isEmpty()) {
	    	sb.append(dq.pollFirst());
	    }

	    return sb.toString();
	}
}
