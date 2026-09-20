package week6_dfs_bfs;

/** [ 네트워크 ]
 * 1. 인접 그래프를 만든다.
 * 2. 0부터 n까지 방문하지 않은 노드를 넣고 BFS(인접 노드 방문)를 수행한다.
 * 3. BFS 수행 횟수를 리턴한다.
 * 
 * Algorithm : 너비 우선 탐색, 그래프
 * Time Complexity : O(N^2)
 * Space Complexity : O(N^2)
 * N <= 200
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class 네트워크_오명헌 {
    public int solution(int n, int[][] computers) {
        
        ArrayList<Integer>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
        	graph[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (computers[i][j] == 1) {
        			graph[i].add(j);
        		}
        	}
        }
        
        Queue<Integer> q = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[n];
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
        	if (visited[i]) continue;
        	
        	answer++;
        	
        	q.add(i);
        	visited[i] = true;
        	
        	while (!q.isEmpty()) {
        		int now = q.poll();
        		
        		for (int next : graph[now]) {
        			if (visited[next]) continue;
        			
        			visited[next] = true;
        			q.add(next);
        		}
        	}
        }
        
        return answer;
    }
}