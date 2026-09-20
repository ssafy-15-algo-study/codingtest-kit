import java.util.Arrays;

class Solution {
    private boolean found = false;
    private String[] answer;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        boolean[] visited = new boolean[tickets.length];
        String[] path = new String[tickets.length + 1];
        path[0] = "ICN";

        func("ICN", 0, tickets, visited, path);

        return answer;
    }

    private void func(String current, int depth, String[][] tickets, boolean[] visited, String[] path) {
        if (found) return;

        if (depth == tickets.length) {
            answer = path.clone();
            found = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                path[depth + 1] = tickets[i][1];
                func(tickets[i][1], depth + 1, tickets, visited, path);
                visited[i] = false;
            }
        }
    }
}