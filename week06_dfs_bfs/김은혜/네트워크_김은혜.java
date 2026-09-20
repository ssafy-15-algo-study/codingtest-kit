package week06_dfs_bfs.김은혜;

import java.util.ArrayDeque;

// 연결된 컴퓨터끼리 같은 네트워크에 있다 할 때, 네트워크 개수
// 컴퓨터 개수 n, 연결 정보 computers
public class 네트워크_김은혜 {

    boolean[] visit;
    ArrayDeque<Integer> deq=new ArrayDeque<>();
    int result=0;

    public int solution(int n, int[][] computers) {
        visit=new boolean[n];

        for(int i=0; i<n; i++){
            if(visit[i]) continue;

            result++;
            deq.add(i);
            visit[i]=true;

            while(!deq.isEmpty()){
                int cur=deq.poll();
                for(int j=0; j<n; j++){
                    if(computers[cur][j]==1 && !visit[j]){
                        deq.add(j);
                        visit[j]=true;
                    }
                }
            }
        }

        return result;
    }
}
