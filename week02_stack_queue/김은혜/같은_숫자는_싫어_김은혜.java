package week02_stack_queue.김은혜;

import java.util.ArrayDeque;

// 0~9로 구성된 배열 arr에서 연속으로 나타나는 숫자 제거 후 남은 수 리턴
public class 같은_숫자는_싫어_김은혜 {

    ArrayDeque<Integer> deq=new ArrayDeque<>();

    public int[] solution(int []arr) {
        for(int n: arr){
            if(deq.isEmpty() || deq.getLast()!=n){
                deq.add(n);
            }
        }

        int[] answer=new int[deq.size()];
        int idx=0;
        while(!deq.isEmpty()){
            answer[idx++]=deq.poll();
        }
        return answer;
    }
}
