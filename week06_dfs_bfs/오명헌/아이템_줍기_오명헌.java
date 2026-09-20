package week6_dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;

class 아이템_줍기_오명헌 {
	
	public static int[] dy = { -1, 1, 0, 0 };
	public static int[] dx = { 0, 0, -1, 1 };
	
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    	int MAX_N = 100;
    	int[][] map = new int[MAX_N + 1][MAX_N + 1];
    	boolean[][] visited = new boolean[MAX_N + 1][MAX_N + 1];
    	
    	for (int[] rec : rectangle) {
    		int y1 = rec[0] * 2;
    		int x1 = rec[1] * 2;
    		int y2 = rec[2] * 2;
    		int x2 = rec[3] * 2;
    		
    		for (int y = y1; y <= y2; y++) {
    			for (int x = x1; x <= x2; x++) {
    				if(map[y][x] == 2) continue;
    				
    				if (y > y1 && y < y2 && x > x1 && x < x2) {
    					map[y][x] = 2;
    				} else {
    					map[y][x] = 1;
    				}
    			}
    		}
    	}

    	int sy = characterX * 2;
    	int sx = characterY * 2;
    	int ey = itemX * 2;
    	int ex = itemY * 2;
    	
    	Queue<int[]> q = new ArrayDeque<int[]>();
    	q.add(new int[] { sy, sx, 0 });
    	visited[sy][sx] = true;
    	
    	int min = MAX_N * MAX_N;
    	
    	while (!q.isEmpty()) {
    		int[] now = q.poll();
    		int y = now[0];
    		int x = now[1];
    		int dist = now[2];
    		
    		if (y == ey && x == ex) {
				min = dist;
				break;
			}
    		
    		for (int i = 0; i < 4; i++) {
    			int ny = y + dy[i];
    			int nx = x + dx[i];
    			
    			if (ny <= 0 || ny > MAX_N || nx <= 0 || nx > MAX_N) continue;
    			if (map[ny][nx] != 1) continue;
    			if (visited[ny][nx]) continue;
    			
    			q.add(new int[] { ny, nx, dist + 1 });
    			visited[ny][nx] = true;
    		}
    	}
        
        return min / 2;
    }
}