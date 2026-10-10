package week09_graph.김은혜;

import java.util.ArrayDeque;

// n개의 노드로 이루어진 그래프에서 1번 노드에서 출발해 가장 멀리 떨어진 노드 개수
// 노드 개수 n, 간선 정보 edge
class Node{
    int num;
    Node next;

    Node(int num, Node next){
        this.num=num;
        this.next=next;
    }
}

public class 가장_먼_노드_김은혜 {

    ArrayDeque<int[]> deq=new ArrayDeque<>();
    Node[] edges;
    boolean[] visit;

    public int solution(int n, int[][] edge) {
        visit=new boolean[n];
        edges=new Node[n];

        for(int i=0; i<edge.length; i++){
            int to=edge[i][0]-1;
            int from=edge[i][1]-1;

            edges[to]=new Node(from, edges[to]);
            edges[from]=new Node(to, edges[from]);
        }

        visit[0]=true;
        deq.add(new int[]{0, 0});

        int dist=0;
        int cnt=0;
        while(!deq.isEmpty()){
            int[] cur=deq.poll();
            if(dist<cur[1]){
                dist=cur[1];
                cnt=1;
            } else if(dist==cur[1]){
                cnt++;
            }

            for(Node node=edges[cur[0]]; node!=null; node=node.next){
                if(visit[node.num]) continue;

                visit[node.num]=true;
                deq.add(new int[]{node.num, cur[1]+1});
            }
        }

        return cnt;
    }
}
