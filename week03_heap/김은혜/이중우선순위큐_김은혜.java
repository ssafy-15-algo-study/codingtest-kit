package week03_heap.김은혜;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// I 숫자: 숫자 삽입, D 1: 큐에서 최대값 삭제, D -1: 큐에서 최소값 삭제
// 연산 operations 주어질 때, 연산 처리 후 큐가 비어있으면 [0, 0], 비어있지 않으면 [최대값, 최소값] 반환
public class 이중우선순위큐_김은혜 {

    PriorityQueue<Integer> min=new PriorityQueue<>();
    PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        for(String s: operations){
            StringTokenizer st=new StringTokenizer(s, " ");

            char order=st.nextToken().charAt(0);
            int num=Integer.parseInt(st.nextToken());
            if(order=='I'){
                min.add(num);
                max.add(num);
            } else{
                if(min.isEmpty() || max.isEmpty()) continue;
                if(num<0){
                    int n=min.poll();
                    max.remove(n);
                } else{
                    int n=max.poll();
                    min.remove(n);
                }
            }
        }

        int[] answer={0, 0};
        if(!min.isEmpty() && !max.isEmpty()){
            answer[0]=max.peek();
            answer[1]=min.peek();
        }

        return answer;
    }
}
