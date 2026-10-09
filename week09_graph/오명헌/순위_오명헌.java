package week9_graph;

/** [ 순위 ]
 * Idea
 * 1. 순방향, 역방향 그래프를 만든다.
 * 2. 특정 노드부터 시작하여 각 그래프 탐색 후 방문한 노드 개수 합이 n - 1이면 순위를 확정할 수 있다.
 * 
 * TimeComplexity : O(N * (N + M))
 * N <= 100
 * M <= 4,500
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        ArrayList<Integer>[] graph1 = new ArrayList[n + 1];
        ArrayList<Integer>[] graph2 = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
        	graph1[i] = new ArrayList<Integer>();
        	graph2[i] = new ArrayList<Integer>();
        }
        
        for (int[] result : results) {
        	int a = result[0];
        	int b = result[1];
        	
        	graph1[a].add(b);
        	graph2[b].add(a);
        }
        
        for (int i = 1; i <= n; i++) {
        	int cnt1 = bfs(n, i, graph1);
        	int cnt2 = bfs(n, i, graph2);
        	
        	if (cnt1 + cnt2 == n - 1) answer++;
        }
        
        return answer;
    }
    
    public static int bfs(int n, int k, ArrayList<Integer>[] graph) {
    	int cnt = 0;
    	
    	boolean[] visited = new boolean[n + 1];
    	Queue<Integer> q = new ArrayDeque<Integer>();
    	
    	visited[k] = true;
    	q.add(k);
    	
    	while (!q.isEmpty()) {
    		int now = q.poll();
    		
    		for (int next : graph[now]) {
    			if (visited[next]) continue;
    			
    			visited[next] = true;
    			q.add(next);
    			cnt++;
    		}
    	}
    	
    	return cnt;
    }
}