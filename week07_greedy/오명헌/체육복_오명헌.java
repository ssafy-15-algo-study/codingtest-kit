package week7_greedy;

class 체육복_오명헌 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] students = new int[n + 2];
        
        for (int l : lost) students[l]--;
        for (int r : reserve) students[r]++;
        
        for (int i = 1; i <= n; i++) {
        	if (students[i] == -1) {
        		if (students[i - 1] == 1) {
        			answer++;
        			students[i - 1]--;
        		}
        		else if (students[i + 1] == 1) {
        			answer++;
        			students[i + 1]--;
        		}
        	}
        	else {
        		answer++;
        	}
        }
        
        return answer;
    }
}