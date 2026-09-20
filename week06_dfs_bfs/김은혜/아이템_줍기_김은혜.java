package week06_dfs_bfs.김은혜;

import java.util.ArrayDeque;

// 직사각형이 겹쳐진 형태의 둘레를 따라 이동
// 직사각형 정보 rectangle: 좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y
// 초기 캐릭터 위치 (characterX, characterY), 아이템 위치(itemX, itemY)
// 캐릭터가 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리 리턴
public class 아이템_줍기_김은혜 {

    int[][] map=new int[100][100];
    boolean[][] visit=new boolean[100][100];
    ArrayDeque<int[]> deq=new ArrayDeque<>();

    // 위부터 시계방향
    int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy={0, 1, 1, 1, 0, -1, -1, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int i=0; i< rectangle.length; i++){
            // map에 직사각형 표시
            for(int j=(rectangle[i][0]-1)*2; j<rectangle[i][2]*2-1; j++){
                for(int z=(rectangle[i][1]-1)*2; z<rectangle[i][3]*2-1; z++){
                    map[z][j]=1;
                }
            }
        }

        deq.add(new int[]{(characterY-1)*2, (characterX-1)*2, 0});
        visit[(characterY-1)*2][(characterX-1)*2]=true;
        int result=0;

        while(!deq.isEmpty()){
            int[] cur=deq.poll();
            int x=cur[0];
            int y=cur[1];
            if(x==(itemY-1)*2 && y==(itemX-1)*2){
                result=cur[2];
                break;
            }

            for(int i=0; i<8; i+=2){
                if(x+dx[i]<0 || x+dx[i]>=100 || y+dy[i]<0 || y+dy[i]>=100) continue;
                if(map[x+dx[i]][y+dy[i]]!=1) continue;
                if(visit[x+dx[i]][y+dy[i]]) continue;

                int gx=x+dx[i]; int gy=y+dy[i];
                for(int j=0; j<8; j++){
                    if(gx+dx[j]<0 || gx+dx[j]>=100 || gy+dy[j]<0 || gy+dy[j]>=100 || map[gx+dx[j]][gy+dy[j]]==0){
                        visit[gx][gy]=true;
                        deq.add(new int[]{gx, gy, cur[2]+1});
                        break;
                    }
                }
            }
        }

        return result/2;
    }
}
