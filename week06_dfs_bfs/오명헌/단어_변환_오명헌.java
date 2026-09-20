package week6_dfs_bfs;

/** [ 단어 변환 ]
 * Algorithm : 너비 우선 탐색
 * Time Complexity : O(N^2 * L)
 * Space Complexity : O(N)
 * N <= 50
 */

import java.util.ArrayDeque;
import java.util.Queue;

class Node {
	String word;
	int count;
	
	public Node (String word, int count) {
		this.word = word;
		this.count = count;
	}
}

class 단어_변환_오명헌 {
	
    public int solution(String begin, String target, String[] words) {
    	int answer = 0;
        
    	Queue<Node> q = new ArrayDeque<Node>();
    	boolean[] visited = new boolean[words.length];
    	
    	q.add(new Node(begin, 0));
    	
    	while (!q.isEmpty()) {
    		
    		Node now = q.poll();
    		
    		if (now.word.equals(target)) {
    			answer = now.count;
    			break;
    		}
    		
    		for (int i = 0; i < words.length; i++) {
    			if (visited[i]) continue;
    			if (!checked(now.word, words[i])) continue;
    			
    			visited[i] = true;
    			q.add(new Node(words[i], now.count + 1));
    		}
    	}
    	
    	return answer;
    }
    
    static boolean checked(String s1, String s2) {
    	
    	int n = s1.length();
    	int cnt = 0;
    	
    	for (int i = 0; i < n; i++) {
    		if (s1.charAt(i) == s2.charAt(i)) {
    			cnt++;
    		}
    	}
    	
    	if (cnt == n - 1) return true;
    	
    	return false;
    }
}