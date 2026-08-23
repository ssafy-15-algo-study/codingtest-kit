package week02_stack_queue.김은혜;

import java.util.ArrayDeque;

// 괄호 쌍이 올바르게 있는지 true/false 리턴
public class 올바른_괄호_김은혜 {

    ArrayDeque<Character> deq=new ArrayDeque<>();

    boolean solution(String s) {
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c=='('){
                deq.add(c);
            } else{
                if(deq.isEmpty()) return false;
                deq.pollLast();
            }
        }

        if(deq.isEmpty()) return true;
        return false;
    }
}
