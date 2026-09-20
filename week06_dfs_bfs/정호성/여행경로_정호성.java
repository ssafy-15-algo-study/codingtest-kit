import java.util.*;
import java.io.*;

class Solution {
    private boolean[] visited;
    private List<String> route = new ArrayList<>();
    private boolean isFound = false;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        visited = new boolean[tickets.length];
        
        route.add("ICN");
        dfs("ICN", 0, tickets);
        
        return route.toArray(new String[0]);
    }
    
    private void dfs(String cur, int cnt, String[][] tickets) {
        if (cnt == tickets.length) {
            isFound = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                route.add(tickets[i][1]);

                dfs(tickets[i][1], cnt + 1, tickets);

                if (isFound) return;

                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }
    }
}