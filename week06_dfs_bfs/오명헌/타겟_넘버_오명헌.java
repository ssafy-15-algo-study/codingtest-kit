package week6_dfs_bfs;

/** [ 타겟 넘버 ]
 * 1. + 인 경우, - 인 경우 깊이 우선 탐색을 수행한다.
 * 
 * Algorithm : 깊이 우선 탐색
 * Time Complexity : O(2^N)
 * N <= 20
 */

class 타겟_넘버_오명헌 {
	
	static int answer;
	
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    static void dfs(int depth, int now, int[] numbers, int target) {
    	
    	if (depth == numbers.length) {
    		if (now == target) answer++;
    		return;
    	}
    	
    	dfs(depth + 1, now + numbers[depth], numbers, target);
    	dfs(depth + 1, now - numbers[depth], numbers, target);
    }
}










