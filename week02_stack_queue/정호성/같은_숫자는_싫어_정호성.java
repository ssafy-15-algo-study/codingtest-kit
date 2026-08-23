import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        answer.add(arr[0]);
        
        for(int i = 1; i < arr.length; ++i) {
            if(arr[i] == answer.get(answer.size() - 1)) {
                continue;
            }
            
            answer.add(arr[i]);
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}