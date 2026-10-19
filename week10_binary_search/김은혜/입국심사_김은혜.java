package week10_binary_search.김은혜;

import java.util.Arrays;

// 입국심사 대기 중인 n명, 심사관별 걸리는 시간 times
// 모든 사람이 심사 받는데 걸리는 시간의 최소값 리턴
public class 입국심사_김은혜 {

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left=1;
        long right=times[times.length-1]*(long)n;

        long answer=0;
        while(left<=right) {
            long mid=(left+right)/2;
            long sum = 0;

            for (int i = 0; i < times.length; i++) {
                // mid동안 각 심사관이 처리한 사람 수 총합
                sum += mid / times[i];
            }

            if(sum<n){
                left=mid+1;
            } else if(sum>=n){
                answer=mid;
                right=mid-1;
            }
        }

        return answer;
    }
}
