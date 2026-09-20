import java.util.*;

class Solution {
    public int solution(int n, int[][] com) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, com, visited);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int current, int n, int[][] com, boolean[] visited) {
        visited[current] = true;

        for (int next = 0; next < n; next++) {
            if (com[current][next] == 1 && !visited[next]) {
                dfs(next, n, com, visited);
            }
        }
    }
}