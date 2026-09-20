import java.util.*;

class Solution {
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;

        // game_board의 빈 공간 추출
        List<List<int[]>> spaces = extractShapes(game_board, 0);
        // table의 퍼즐 조각 추출
        List<List<int[]>> puzzles = extractShapes(table, 1);

        boolean[] usedSpace = new boolean[spaces.size()];
        int answer = 0;

        // 퍼즐 조각과 빈 공간 매칭
        for (List<int[]> puzzle : puzzles) {
            for (int i = 0; i < spaces.size(); i++) {
                if (usedSpace[i] || puzzle.size() != spaces.get(i).size()) continue;

                if (isMatch(puzzle, spaces.get(i))) {
                    usedSpace[i] = true;
                    answer += puzzle.size();
                    break;
                }
            }
        }

        return answer;
    }

    private List<List<int[]>> extractShapes(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> shapes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == target && !visited[i][j]) {
                    shapes.add(bfs(board, visited, i, j, target));
                }
            }
        }
        return shapes;
    }

    private List<int[]> bfs(int[][] board, boolean[][] visited, int startX, int startY, int target) {
        List<int[]> points = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();

        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            points.add(curr);

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board.length) {
                    if (!visited[nx][ny] && board[nx][ny] == target) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return normalize(points);
    }

    // 좌표 0, 0 기준으로 이동 후 정렬
    private List<int[]> normalize(List<int[]> points) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] p : points) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }

        List<int[]> normalized = new ArrayList<>();
        for (int[] p : points) {
            normalized.add(new int[]{p[0] - minX, p[1] - minY});
        }

        normalized.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        return normalized;
    }

    private List<int[]> rotate(List<int[]> points) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : points) {
            rotated.add(new int[]{p[1], -p[0]});
        }
        return normalize(rotated);
    }

    // 회전하면서 일치하는지 체크
    private boolean isMatch(List<int[]> puzzle, List<int[]> space) {
        List<int[]> current = puzzle;
        for (int r = 0; r < 4; r++) {
            if (isSame(current, space)) return true;
            current = rotate(current);
        }
        return false;
    }

    private boolean isSame(List<int[]> a, List<int[]> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }
}