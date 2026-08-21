package week02_stack_queue.김은혜;

import java.util.ArrayDeque;

// 작업 진도가 적힌 배열 progresses + 각 작업 개발 속도가 적힌 배열 speeds
// 배포마다 몇 개의 기능이 배포되는지 리턴
public class 기능개발_김은혜 {

    ArrayDeque<Integer> deq=new ArrayDeque<>();

    public int[] solution(int[] progresses, int[] speeds) {
        int func=1, dep=0;

        for(int i=0; i< progresses.length; i++){
            int rem=100-progresses[i];
            int day=rem/speeds[i];
            if(rem%speeds[i]>0) {
                day += 1;
            }

            if(i==0 || dep<day){
                if(i!=0) deq.add(func);
                dep=day;
                func=1;
            } else {
                func++;
            }
        }
        deq.add(func);

        int[] answer=new int[deq.size()];
        int idx=0;
        while(!deq.isEmpty()){
            answer[idx++]=deq.poll();
        }

        return answer;
    }
}
