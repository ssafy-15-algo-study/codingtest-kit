package week2_stack_queue;

/** [올바른 괄호]
 * Idea
 * 1. 문자열 s를 한 글자씩 순회한다.
 * 2. '(' 모양일 경우 stack에 push, ')' 모양일 경우 stack이 비어있으면 false, 비어있지 않으면 pop한다.
 * 3. 모든 순회를 마친 후 stack이 비어있으면 true, 비어있지 않으면 false 를 반환한다.
 * 
 * Algorithm : 스택
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */

import java.util.Stack;

class 올바른_괄호_오명헌 {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if (c == '(') {
        		stack.add(c);
        	} else {
        		if (stack.isEmpty()) {
        			return false;
        		} else {
        			stack.pop();
        		}
        	}
        }
        
        if (stack.isEmpty()) return true; 
        else return false;
    }
}