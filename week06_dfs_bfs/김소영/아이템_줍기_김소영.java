import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int[][] map = new int[101][101];

		for (int[] r : rectangle) {
			int x1 = r[0] * 2, y1 = r[1] * 2;
			int x2 = r[2] * 2, y2 = r[3] * 2;

			for (int x = x1; x <= x2; x++) {
				for (int y = y1; y <= y2; y++) {
					if (map[x][y] == 2)
						continue;
					if (x == x1 || x == x2 || y == y1 || y == y2) {
						map[x][y] = 1;
					} else {
						map[x][y] = 2;
					}
				}
			}
		}

		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[101][101];
		int startX = characterX * 2, startY = characterY * 2;
		int targetX = itemX * 2, targetY = itemY * 2;

		queue.offer(new int[] { startX, startY, 0 });
		visited[startX][startY] = true;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0], y = curr[1], dist = curr[2];

			if (x == targetX && y == targetY) {
				return dist / 2;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100) {
					if (!visited[nx][ny] && map[nx][ny] == 1) {
						visited[nx][ny] = true;
						queue.offer(new int[] { nx, ny, dist + 1 });
					}
				}
			}
		}

		return 0;
	}
}