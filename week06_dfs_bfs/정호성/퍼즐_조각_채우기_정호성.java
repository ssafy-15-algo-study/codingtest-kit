import java.util.*;

class Solution {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;

        List<List<XY>> spaces = new ArrayList<>();
        List<List<XY>> puzzles = new ArrayList<>();

        boolean[][] v1 = new boolean[n][n];
        boolean[][] v2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!v1[i][j] && game_board[i][j] == 0) {
                    spaces.add(bfs(game_board, v1, i, j, 0, n));
                }
                if (!v2[i][j] && table[i][j] == 1) {
                    puzzles.add(bfs(table, v2, i, j, 1, n));
                }
            }
        }

        boolean[] used = new boolean[puzzles.size()];
        int answer = 0;

        for (List<XY> space : spaces) {
            for (int i = 0; i < puzzles.size(); i++) {
                if (used[i]) continue;

                List<XY> puzzle = puzzles.get(i);
                if (space.size() != puzzle.size()) continue;

                if (isMatch(space, puzzle)) {
                    used[i] = true;
                    answer += space.size();
                    break;
                }
            }
        }

        return answer;
    }
    
    private List<XY> bfs(int[][] board, boolean[][] visited, int sx, int sy, int target, int n) {
        List<XY> list = new ArrayList<>();
        Queue<XY> q = new LinkedList<>();

        q.offer(new XY(sx, sy));
        visited[sx][sy] = true;

        int minX = sx, minY = sy;

        while (!q.isEmpty()) {
            XY cur = q.poll();
            list.add(cur);

            minX = Math.min(minX, cur.x);
            minY = Math.min(minY, cur.y);

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] || board[nx][ny] != target) continue;

                visited[nx][ny] = true;
                q.offer(new XY(nx, ny));
            }
        }
        
        
        List<XY> result = new ArrayList<>();
        for (XY p : list) {
            result.add(new XY(p.x - minX, p.y - minY));
        }
        Collections.sort(result);

        return result;
    }
    
    private boolean isMatch(List<XY> space, List<XY> puzzle) {
        List<XY> cur = puzzle;

        for (int r = 0; r < 4; r++) {
            if (space.equals(cur)) return true;
            
            cur = rotate(cur);
        }

        return false;
    }
    
    private List<XY> rotate(List<XY> list) {
        List<XY> rotated = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (XY p : list) {
            int rx = p.y;
            int ry = -p.x;
            rotated.add(new XY(rx, ry));

            minX = Math.min(minX, rx);
            minY = Math.min(minY, ry);
        }

        List<XY> result = new ArrayList<>();
        for (XY p : rotated) {
            result.add(new XY(p.x - minX, p.y - minY));
        }
        Collections.sort(result);

        return result;
    }
    
    static class XY implements Comparable<XY> {
        int x, y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(XY o) {
            if (this.x == o.x) return Integer.compare(this.y, o.y);
            return Integer.compare(this.x, o.x);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof XY)) return false;
            XY p = (XY) o;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}