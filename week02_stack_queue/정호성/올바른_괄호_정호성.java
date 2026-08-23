import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        List<Character> stk = new ArrayList<>();
        
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int lastIdx = stk.size() - 1;
            
            if(c == '(') {
                stk.add(c);
            } else {
                if(stk.isEmpty()) {
                    answer = false;
                    break;
                }
                else {
                    stk.remove(lastIdx);
                }
            }
        }
        
        if(!stk.isEmpty()) answer = false;
        

        return answer;
    }
}