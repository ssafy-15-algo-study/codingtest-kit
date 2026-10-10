package week09_graph.김은혜;

import java.util.HashSet;
import java.util.Objects;

// 이동 방향이 담김 배열 arrows 주어질 때, 만들어지는 방의 개수 리턴
// 이동 방향: 0~7(위부터 시계 방향)
class Point{
    int x1, y1, x2, y2;

    Point(int x1, int y1, int x2, int y2){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
    }

    public int hashCode(){
        return Objects.hash(x1, y1) + Objects.hash(x2, y2);
    }

    public boolean equals(Object o){
        boolean same=false, reversed=false;
        Point p=(Point) o;

        if(this.x1==p.x1 && this.y1==p.y1
            && this.x2==p.x2 && this.y2==p.y2) same=true;
        if(this.x1==p.x2 && this.y1==p.y2
            && this.x2==p.x1 && this.y2==p.y1) reversed=true;

        return same || reversed;
    }
}

public class 방의_개수_김은혜 {

    int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy={0, 1, 1, 1, 0, -1, -1, -1};

    public int solution(int[] arrows) {
        int x=0, y=0;
        HashSet<Point> visit=new HashSet<>();
        visit.add(new Point(x, y, x, y));

        int cnt=0;
        for(int d: arrows){
            // 크기 확장
            for(int i=0; i<2; i++){
                int nx=x+dx[d];
                int ny=y+dy[d];

                Point edge=new Point(x, y, nx, ny);
                Point node=new Point(nx, ny, nx, ny);

                // 방문한 점 + 처음 지나는 간선 -> 방 생성
                if(!visit.contains(edge) && visit.contains(node)) cnt++;

                visit.add(edge);
                visit.add(node);

                x=nx;
                y=ny;
            }
        }

        return cnt;
    }
}
