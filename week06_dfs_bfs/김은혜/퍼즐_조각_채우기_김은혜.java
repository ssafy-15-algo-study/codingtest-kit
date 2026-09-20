package week06_dfs_bfs.김은혜;

import java.util.ArrayDeque;
import java.util.ArrayList;

// 퍼즐 조각으로 게임 보드의 빈칸을 채울 때, 최대 채울 수 있는 칸 수
// 퍼즐 조각 회전 가능(뒤집기 불가능) + 채워 넣은 퍼즐 조각과 인접한 칸 비어있으면 안됨
public class 퍼즐_조각_채우기_김은혜 {

    ArrayList<ArrayList<int[]>> puzzle=new ArrayList<>();
    ArrayList<ArrayList<int[]>> blank=new ArrayList<>();

    ArrayDeque<int[]> deq=new ArrayDeque<>();
    boolean[][] vt, vb;

    int[] dx={-1, 1, 0, 0};
    int[] dy={0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        vt=new boolean[table.length][table[0].length];
        vb=new boolean[game_board.length][game_board[0].length];

        for(int i=0; i<table.length; i++){
            for(int j=0; j<table[0].length; j++){
                if(table[i][j]==1 && !vt[i][j]){
                    bfs(table, vt, puzzle, 1, i, j);
                }

                if(game_board[i][j]==0 && !vb[i][j]){
                    bfs(game_board, vb, blank, 0, i, j);
                }
            }
        }

        int answer=0;
        boolean[] visitBlank=new boolean[blank.size()];

        for(int i=0; i< puzzle.size(); i++){
            ArrayList<int[]> p=puzzle.get(i);
            for(int j=0; j<blank.size(); j++){
                ArrayList<int[]> b=blank.get(j);

                if(p.size()==b.size() && !visitBlank[j]){
                    if(rotate(p, b)){
                        answer+=p.size();
                        visitBlank[j]=true;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    void bfs(int[][] pan, boolean[][] visit, ArrayList<ArrayList<int[]>> list, int n, int sx, int sy){
        ArrayList<int[]> sub=new ArrayList<>();

        deq.add(new int[]{sx, sy});
        visit[sx][sy]=true;
        sub.add(new int[]{sx-sx, sy-sy});

        while(!deq.isEmpty()){
            int[] cur=deq.poll();
            int cx=cur[0];
            int cy=cur[1];

            for(int i=0; i<4; i++){
                if(cx+dx[i]<0 || cx+dx[i]>=pan.length || cy+dy[i]<0 || cy+dy[i]>=pan[0].length) continue;
                if(visit[cx+dx[i]][cy+dy[i]]) continue;
                if(pan[cx+dx[i]][cy+dy[i]]!=n) continue;

                visit[cx+dx[i]][cy+dy[i]]=true;
                deq.add(new int[]{cx+dx[i], cy+dy[i]});
                sub.add(new int[]{cx+dx[i]-sx, cy+dy[i]-sy});
            }
        }

        list.add(sub);
    }

    boolean rotate(ArrayList<int[]> p, ArrayList<int[]> b){
        // 회전해도 같은 인덱스끼리 비교하기 위해 정렬
        // 정렬 시 인덱스 0번이 가장 좌상단
        b.sort((o1, o2) -> {
            return o1[0] > o2[0]?1 : o1[0] < o2[0]?-1 : Integer.compare(o1[1], o2[1]);
        });

        boolean isFill=false;
        // 0, 90, 180, 270 회전
        for(int i=0; i<4; i++){
            p.sort((o1, o2) -> {
                return o1[0] > o2[0]?1 : o1[0] < o2[0]?-1 : Integer.compare(o1[1], o2[1]);
            });

            int x=p.get(0)[0];
            int y=p.get(0)[1];
            // 정규화
            for(int j=0; j<p.size(); j++){
                p.get(j)[0]-=x;
                p.get(j)[1]-=y;
            }

            boolean isSame=true;
            for(int j=0; j<b.size(); j++){
                int[] bp=b.get(j);
                int[] pp=p.get(j);

                if(bp[0]!=pp[0] || bp[1]!=pp[1]){
                    isSame=false;
                    break;
                }
            }

            if(isSame){
                isFill=true;
                break;
            } else{
                // 다음 회전 진행
                // 90도 회전: (x, y) -> (y, -x)
                for(int j=0; j<p.size(); j++){
                    int temp=p.get(j)[0];
                    p.get(j)[0]=p.get(j)[1];
                    p.get(j)[1]=-temp;
                }
            }
        }

        return isFill;
    }
}
