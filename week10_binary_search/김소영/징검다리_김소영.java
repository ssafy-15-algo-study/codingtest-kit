import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        int answer = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int removedRocks = 0;
            int prevPosition = 0;
            
            for (int rock : rocks) {
                if (rock - prevPosition < mid) {
                    removedRocks++;
                } else {
                    prevPosition = rock;
                }
            }
            
            // 도착 지점과의 거리 검사
            if (distance - prevPosition < mid) {
                removedRocks++;
            }
            
            if (removedRocks <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}