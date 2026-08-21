package week02_stack_queue.김은혜;

import java.util.ArrayDeque;

// 일차선 다리를 정해진 순서대로 건너는데 걸리는 최소 시간(s)
// 다리에는 최대 bridge_length대, weight 이하 무게, 트럭별 무게 truck_weight
class Truck{
    int idx;
    int out;

    Truck(int idx, int out){
        this.idx=idx;
        this.out=out;
    }
}

public class 다리를_지나는_트럭_김은혜 {

    ArrayDeque<Truck> deq=new ArrayDeque<>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sec=1, idx=0, cur=0;

        while(idx<truck_weights.length){
            while(deq.size()<bridge_length && idx<truck_weights.length && cur+truck_weights[idx]<=weight){
                if(!deq.isEmpty() && deq.peek().out<=sec){
                    cur-=truck_weights[deq.poll().idx];
                }
                deq.add(new Truck(idx, sec+bridge_length));
                cur+=truck_weights[idx++];
                sec++;
            }

            Truck t=deq.poll();
            sec=t.out;
            System.out.print(sec + " ");
            cur-=truck_weights[t.idx];
        }

        while(!deq.isEmpty()) sec=deq.poll().out;
        return sec;
    }
}
