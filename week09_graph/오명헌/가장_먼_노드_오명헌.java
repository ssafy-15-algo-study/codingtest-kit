package week9_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class 가장_먼_노드_오명헌 {
	
	public static int MAX = 1_000_000_000;
	
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
        	graph[i] = new ArrayList<Integer>();
        }
        
        for (int[] e : edge) {
        	int a = e[0];
        	int b = e[1];
        	
        	graph[a].add(b);
        	graph[b].add(a);
        }
        
        int[] dist = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
        	dist[i] = MAX;
        }
        
        dist[1] = 0;
        
        Queue<int[]> q = new ArrayDeque<int[]>();
        q.add(new int[] { 1, 1 });
        
        while (!q.isEmpty()) {
        	int[] now = q.poll();
        	int node = now[0];
        	int distance = now[1];
        	
        	for (int next : graph[node]) {
        		if (dist[next] != MAX) continue;
        		
        		dist[next] = distance + 1;
        		q.add(new int[] { next, distance + 1 });
        	}
        	
        }
        
        int max_distance = -1;
        
        for (int i = 1; i <= n; i++) {
        	if (dist[i] == MAX) continue;
        	max_distance = Math.max(max_distance, dist[i]);
        }
        
        for (int i = 1; i <= n; i++) {
        	if (dist[i] == max_distance) answer++;
        }
        
        return answer;
    }
}























