package week02_stack_queue.김은혜;

import java.util.ArrayDeque;

// 초 단위 주식가격 배열 prices -> 가격 떨어지지 않은 기간 몇 초인지 리턴
public class 주식가격_김은혜 {

    ArrayDeque<Integer> deq=new ArrayDeque<>();

    public int[] solution(int[] prices) {
        int[] arr=new int[prices.length];

        for(int i=0; i<prices.length; i++){
            if(deq.isEmpty() || prices[deq.peekLast()]<=prices[i]){
                deq.add(i);
            } else{
                int idx=deq.pollLast();
                arr[idx]=i-idx;
                i--;
            }
        }

        int end=prices.length-1;
        while(!deq.isEmpty()){
            int idx=deq.pollLast();
            arr[idx]=end-idx;
        }

        return arr;
    }
}
