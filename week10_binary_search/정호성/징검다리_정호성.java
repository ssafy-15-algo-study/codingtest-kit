import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        long left = 1;
        long right = distance;
        int answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2; 
            int removedCount = 0;
            int prev = 0;

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    removedCount++;
                } else {
                    prev = rock;
                }
            }

            if (distance - prev < mid) {
                removedCount++;
            }

            if (removedCount > n) {
                right = mid - 1;
            } else {
                answer = (int) mid;
                left = mid + 1;
            }
        }

        return answer;
    }
}