package week02_stack_queue.김은혜;

import java.util.*;

class Proc implements Comparable<Proc>{
    int idx;
    int high;

    Proc(int idx, int high){
        this.idx=idx;
        this.high=high;
    }

    @Override
    public int compareTo(Proc o) {
        return Integer.compare(o.high, this.high);
    }
}

public class 프로세스_김은혜 {

    PriorityQueue<Proc> pq=new PriorityQueue<>();
    ArrayDeque<Integer> deq=new ArrayDeque<>();

    public int solution(int[] priorities, int location) {
        for(int i=0; i<priorities.length; i++){
            pq.add(new Proc(i, priorities[i]));
            deq.add(i);
        }

        int start=1;
        while(!deq.isEmpty()){
            int idx=deq.poll();
            if(priorities[idx]==pq.peek().high){
                pq.poll();
                if(idx==location) return start;
                start++;
            } else{
                deq.add(idx);
            }
        }

        return start;
    }
}
