import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < prices.length; ++i) {
            while(!stack.isEmpty()) { // 스택이 비워질때까지
                if(prices[stack.peek()] > prices[i]) { // 가격이 이전보다 현재에 떨어졌다면
                    int prev = stack.pop();
                    answer[prev] = i - prev; // 해당 날짜와 현재 날짜의 차가 가격이 떨어진 기간임.
                } else {
                    break;
                }
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int prev = stack.pop();
            answer[prev] = prices.length - 1 - prev;
        }
        
        return answer;
    }
    
}