package week06_dfs_bfs.김은혜;

import java.util.ArrayDeque;

// n*m 맵에 좌상단에 위치한 캐릭터가 우하단에 도달하는 최단거리(도착 못하면 -1)
public class 게임_맵_최단거리_김은혜 {

    boolean[][] visit;
    ArrayDeque<int[]> deq=new ArrayDeque<>();

    int[] dx={-1, 1, 0, 0};
    int[] dy={0, 0, -1, 1};
    int result=-1;

    public int solution(int[][] maps) {
        visit=new boolean[maps.length][maps[0].length];
        deq.add(new int[]{0, 0, 1});
        visit[0][0]=true;

        while(!deq.isEmpty()){
            int[] cur=deq.poll();

            int x=cur[0];
            int y=cur[1];
            if(x==maps.length-1 && y==maps[0].length-1){
                result=cur[2];
                break;
            }

            for(int i=0; i<4; i++){
                if(x+dx[i]<0 || x+dx[i]>=maps.length || y+dy[i]<0 || y+dy[i]>=maps[0].length) continue;
                if(maps[x+dx[i]][y+dy[i]]==0 || visit[x+dx[i]][y+dy[i]]) continue;

                visit[x+dx[i]][y+dy[i]]=true;
                deq.add(new int[]{x+dx[i], y+dy[i], cur[2]+1});
            }
        }

        return result;
    }
}
