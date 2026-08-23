import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                // 가격이 떨어지면 탐색 중단
                if (prices[i] > prices[j]) 
                    break;
                
            }
        }
        return answer;
    }
}