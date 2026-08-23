import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
         ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i : arr) {
        	if(!list.isEmpty() && list.getLast() == i)
        		continue;
        	list.add(i);
        }
   
        // 리스트 원소들의 스트림 생성 -> 래퍼 객체인 Integer를 기본형인 int로 변환 후
        // int 스트림의 데이터를 모아 int[] 배열 생성
        return list.stream().mapToInt(x -> x).toArray();

    }
}