package week04_sorting.김은혜;

import java.util.Arrays;

// 논문 n편 중, h번 이상 인용된 논문이 h평 이상이고 나머지 논무이 h번 이하 인용된 경우 h의 최대값이 h-index
// 과학자가 발표한 논문의 인용 횟수 담은 배열 citations 주어질 때, h-index return
public class H_Index_김은혜 {

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i=citations.length; i>=0; i--){
            int high=0;
            for(int j=citations.length-1; j>=0; j--){
                if(citations[j]>=i){
                    high++;
                } else{
                    break;
                }
            }

            if(high>=i && citations.length-high<=i){
                answer=i;
                break;
            }
        }
        return answer;
    }
}
