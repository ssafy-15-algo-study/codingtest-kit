package week09_graph.김은혜;

import java.util.ArrayDeque;
import java.util.ArrayList;

// 경기 결과(results) 토대로 순위를 매길 수 있는 선수 수 리턴
// 선수 수 n, results: [A, B]는 A가 B를 이겼다 -> A는 B에게 항상 이김
public class 순위_김은혜 {

    ArrayList<Integer>[] lose, win;
    int answer=0;

    public int solution(int n, int[][] results) {
        lose=new ArrayList[n];
        win=new ArrayList[n];

        for(int i=0; i<n; i++){
            lose[i]=new ArrayList<>();
            win[i]=new ArrayList<>();
        }

        for(int i=0; i<results.length; i++){
            int winner=results[i][0]-1;
            int loser=results[i][1]-1;

            win[winner].add(loser);
            lose[loser].add(winner);
        }

        boolean[] visit;
        ArrayDeque<Integer> deq=new ArrayDeque<>();
        for(int i=0; i<n; i++){
            visit=new boolean[n];
            int cnt=0;

            visit[i]=true;
            deq.add(i);
            while(!deq.isEmpty()){
                int cur=deq.poll();

                for(int k: win[cur]){
                    if(visit[k]) continue;

                    visit[k]=true;
                    deq.add(k);
                    cnt++;
                }
            }

            deq.add(i);
            while(!deq.isEmpty()){
                int cur=deq.poll();

                for(int k: lose[cur]){
                    if(visit[k]) continue;

                    visit[k]=true;
                    deq.add(k);
                    cnt++;
                }
            }

            if(cnt==n-1) answer++;
        }

        return answer;
    }
}
