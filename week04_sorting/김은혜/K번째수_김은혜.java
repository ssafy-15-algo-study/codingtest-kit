package week04_sorting.김은혜;

import java.util.ArrayList;
import java.util.Collections;

// array의 i번째부터 j번째까지 잘라 정렬했을 때, k번째 있는 수
public class K번째수_김은혜 {

    ArrayList<Integer> nums;

    public int[] solution(int[] array, int[][] commands) {
        int[] answer=new int[commands.length];

        for(int i=0; i<commands.length; i++){
            nums=new ArrayList<>();
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                nums.add(array[j]);
            }

            Collections.sort(nums);
            answer[i]=nums.get(commands[i][2]-1);
        }

        return answer;
    }
}
