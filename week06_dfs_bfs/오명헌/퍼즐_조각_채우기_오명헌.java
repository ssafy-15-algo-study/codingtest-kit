package week6_dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class 퍼즐_조각_채우기_오명헌 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) return this.y - o.y;
            return this.x - o.x;
        }

        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }
    }

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int n = game_board.length;

        boolean[][] boardVisited = new boolean[n][n];
        boolean[][] tableVisited = new boolean[n][n];

        List<List<Point>> spaces = new ArrayList<>();
        List<List<Point>> pieces = new ArrayList<>();

        // 1. bfs로 빈 공간(0)과 퍼즐 조각(1) 각각을 찾는다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 게임 보드의 빈 공간 추출 (0을 찾음)
                if (game_board[i][j] == 0 && !boardVisited[i][j]) {
                    spaces.add(extract(game_board, boardVisited, i, j, 0, n));
                }
                // 테이블의 퍼즐 조각 추출 (1을 찾음)
                if (table[i][j] == 1 && !tableVisited[i][j]) {
                    pieces.add(extract(table, tableVisited, i, j, 1, n));
                }
            }
        }

        boolean[] used = new boolean[pieces.size()]; // 퍼즐 조각 사용 여부

        // 2 & 3. game_board에 찾은 조각들을 대조시키며 최대한 많이 들어가게 구한다.
        for (List<Point> space : spaces) {
            for (int i = 0; i < pieces.size(); i++) {
                if (used[i]) continue;
                
                List<Point> piece = pieces.get(i);
                
                // 빈 공간과 조각의 칸 수가 다르면 아예 들어갈 수 없음 (인접칸 비어있음 방지)
                if (space.size() != piece.size()) continue;

                boolean matched = false;
                
                // 조각을 90도씩 회전시키며 4번 확인한다.
                for (int r = 0; r < 4; r++) {
                    if (isMatch(space, piece)) {
                        matched = true;
                        break;
                    }
                    piece = rotate(piece);
                }

                // 맞았다면 퍼즐을 사용 처리하고, 채운 칸 수만큼 정답에 더함
                if (matched) {
                    used[i] = true;
                    answer += space.size();
                    break; // 해당 빈 공간은 채웠으므로 다음 빈 공간으로 넘어감
                }
            }
        }

        return answer;
    }

    // BFS를 이용해 덩어리를 추출하고 정규화하여 반환
    public List<Point> extract(int[][] board, boolean[][] visited, int x, int y, int target, int n) {
        List<Point> list = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        
        q.offer(new Point(x, y));
        visited[x][y] = true;
        list.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny] && board[nx][ny] == target) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                        list.add(new Point(nx, ny));
                    }
                }
            }
        }
        return normalize(list);
    }

    // 좌표 정규화: 도형의 가장 좌측 상단을 (0,0)으로 맞추고 정렬
    public List<Point> normalize(List<Point> list) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (Point p : list) {
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
        }

        for (Point p : list) {
            p.x -= minX;
            p.y -= minY;
        }

        Collections.sort(list); // 좌표 비교를 위해 정렬
        return list;
    }

    // 조각을 90도 회전
    public List<Point> rotate(List<Point> list) {
        List<Point> rotated = new ArrayList<>();
        for (Point p : list) {
            // 90도 회전 공식: (x, y) -> (y, -x)
            rotated.add(new Point(p.y, -p.x)); 
        }
        return normalize(rotated); // 회전 후 좌표가 엇나갔으므로 다시 정규화
    }

    // 두 덩어리(빈 공간과 조각)가 완전히 일치하는지 비교
    public boolean isMatch(List<Point> space, List<Point> piece) {
        for (int i = 0; i < space.size(); i++) {
            if (!space.get(i).equals(piece.get(i))) {
                return false;
            }
        }
        return true;
    }
}