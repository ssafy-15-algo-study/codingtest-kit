package week6_dfs_bfs;
import java.util.ArrayList;
import java.util.Collections;

/** [ 여행경로 ]
 * Algorithm : 깊이 우선 탐색
 * Time Complexity : O(N!)
 * Space Complexity : O(N)
 */

class 여행경로_오명헌 {
	
	static boolean[] visited;
	static ArrayList<String> list;
	
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        list = new ArrayList<String>();
        
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    static void dfs(int depth, String now, String s, String[][] tickets) {
    	
    	if (depth == tickets.length) {
    		list.add(s);
    		return;
    	}
    	
    	for (int i = 0; i < tickets.length; i++) {
    		if (visited[i]) continue;
    		if (now.equals(tickets[i][0])) {
    			visited[i] = true;
    			dfs(depth + 1, tickets[i][1], s + " " + tickets[i][1], tickets);
    			
    			visited[i] = false;
    		}
    	}
    }
}