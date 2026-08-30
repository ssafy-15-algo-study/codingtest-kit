package week03_heap.김은혜;

import java.util.PriorityQueue;

// 모든 음식의 스코빌 지수를 K 이상으로 만들기 위한 최소 횟수
// 섞은 음식 스코빌 지수 = 가장 최하위 스코빌 지수 + (두 번째 하위 스코빌 지수*2)
public class 더_맵게_김은혜 {

    PriorityQueue<Integer> pq=new PriorityQueue<>();

    public int solution(int[] scoville, int K) {
        for(int s: scoville){
            pq.add(s);
        }

        int num=0;
        while(pq.peek()<K){
            if(pq.size()<2){
                num=-1;
                break;
            }

            int last=pq.poll();
            int last2=pq.poll();
            pq.add(last+(last2*2));
            num++;
        }

        return num;
    }
}
