package week03_heap.김은혜;

import java.util.PriorityQueue;

// 우선순위 디스크 컨트롤러: 작업번호+작업 요청시각+작업 소요시간 저장
// 하드디스크가 작업 하고 있지 않으면 작업 꺼내 시킴(소요시간 짧은 -> 요청 시각 빠른 -> 번호 작은 순서)
// 작업번호 i번의 [작업 요청 시점, 작업 소요시간] jobs 주어질 때, 모든 요청 작업의 반환 시간 평균의 정수부분 리턴
class Task implements Comparable<Task>{
    int idx, req, time;

    Task(int idx, int req, int time){
        this.idx=idx;
        this.req=req;
        this.time=time;
    }

    @Override
    public int compareTo(Task o) {
        int ctime=Integer.compare(this.time, o.time);
        if(ctime!=0) return ctime;

        int creq=Integer.compare(this.req, o.req);
        if(creq!=0) return creq;

        return Integer.compare(this.idx, o.idx);
    }
}

class Req implements Comparable<Req>{
    int idx, req;

    Req(int idx, int req){
        this.idx=idx;
        this.req=req;
    }

    @Override
    public int compareTo(Req o) {
        return Integer.compare(this.req, o.req);
    }
}

public class 디스크_컨트롤러_김은혜 {

    PriorityQueue<Task> pq=new PriorityQueue<>();
    PriorityQueue<Req> rpq=new PriorityQueue<>();

    public int solution(int[][] jobs) {
        for(int j=0; j<jobs.length; j++){
            rpq.add(new Req(j, jobs[j][0]));
        }

        int cur=0, answer=0;
        while(!rpq.isEmpty() || !pq.isEmpty()){
            while(!rpq.isEmpty() && cur>=rpq.peek().req){
                int i=rpq.poll().idx;
                pq.add(new Task(i, jobs[i][0], jobs[i][1]));
            }

            if(pq.isEmpty() && !rpq.isEmpty()) {
                cur=rpq.peek().req;
                continue;
            }
            Task t=pq.poll();
            cur+=t.time;
            answer+=(cur-t.req);
        }

        return answer/jobs.length;
    }
}
