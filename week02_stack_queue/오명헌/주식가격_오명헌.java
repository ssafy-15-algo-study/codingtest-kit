package week2_stack_queue;

/** [ 주식가격 ]
 * Algorithm : 스택
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * N <= 100,000
 */

import java.util.Stack;

class Stock {
	int id;
	int price;
	
	public Stock (int id, int price) {
		this.id = id;
		this.price = price;
	}
}

class 주식가격_오명헌 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Stock> stack = new Stack<Stock>();
        stack.push(new Stock(0, prices[0]));
        
        int prev = prices[0];
        prices[prices.length - 1] = -1;
        
        for (int i = 1; i < prices.length; i++) {
        	Stock stock = new Stock(i, prices[i]);
        	int now = prices[i];
        	
        	if (now < prev) {
        		while (!stack.isEmpty()) {
        			Stock prev_stock = stack.pop();
        			
        			answer[prev_stock.id] = i - prev_stock.id;
        			
        			if (!stack.isEmpty() && now < stack.peek().price) {
        				continue;
        			} else {
        				break;
        			}
        		}
        	}
        	
        	stack.push(stock);
    		prev = now;
        }
        
        return answer;
    }
}