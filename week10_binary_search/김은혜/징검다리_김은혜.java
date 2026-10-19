package week10_binary_search.김은혜;

import java.util.Arrays;

// 출발지부터 도착지까지 거리 distance 사이에 바위 위치(위치정보 rocks)
// 바위 n 개 제거한 뒤 출발지점, 도착지점, 바위 간 거리의 최소값 중 최대값 리턴
public class 징검다리_김은혜 {

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left=1;
        int right=distance;
        int answer=0;

        while(left<=right){
            int mid=(left+right)/2;

            if(remove(rocks, distance, mid)<=n){
                answer=mid;
                left=mid+1;
            } else{
                right=mid-1;
            }
        }

        return answer;
    }

    int remove(int[] rocks, int distance, int mid){
        int before=0;
        int cnt=0;

        for(int i=0; i<rocks.length; i++){
            if(rocks[i]-before<mid){
                cnt++;
                continue;
            }
            before=rocks[i];
        }

        if(distance-before<mid) cnt++;
        return cnt;
    }
}
