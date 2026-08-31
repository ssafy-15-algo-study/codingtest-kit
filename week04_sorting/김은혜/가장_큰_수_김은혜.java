package week04_sorting.김은혜;

import java.util.ArrayList;
import java.util.Comparator;

// 0 또는 양의 정수 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수
public class 가장_큰_수_김은혜 {

    ArrayList<String> nums=new ArrayList<>();

    public String solution(int[] numbers) {
        for(int n: numbers){
            nums.add(String.valueOf(n));
        }

        nums.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 내림차순
                return (o2+o1).compareTo(o1+o2);
                // 오름차순
//                return (o1+o2).compareTo(o2+o1);
            }
        });

        String answer="";
        for(String s: nums){
            answer+=s;
        }

        // numbers 배열의 모든 원소가 0일 때:
        if(answer.charAt(0)=='0') answer="0";
        return answer;
    }
}
