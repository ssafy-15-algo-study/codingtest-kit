package week6_dfs_bfs;

/** [ 게임 맵 최단거리 ]
 * Algorithm : 너비 우선 탐색
 * Time Complexity : O(N^2)
 * Space Complexity : O(N^2)
 * N <= 100
 */

import java.util.ArrayDeque;
import java.util.Queue;

class 게임_맵_최단거리_오명헌 {
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
    public int solution(int[][] maps) {
        int answer = -1;
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<int[]>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new int[] { 0, 0, 1 });
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
        	int[] now = q.poll();
        	int y = now[0];
        	int x = now[1];
        	int dist = now[2];
        	
        	if (y == n - 1 && x == m - 1) {
        		answer = dist;
        		break;
        	}
        	
        	for (int i = 0; i < 4; i++) {
        		int ny = y + dy[i];
        		int nx = x + dx[i];
        		
        		if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
        		if (visited[ny][nx] || maps[ny][nx] == 0) continue;
        		
        		q.add(new int[] { ny, nx, dist + 1 });
        		visited[ny][nx] = true;
        	}
        }
        
        return answer;
    }
}