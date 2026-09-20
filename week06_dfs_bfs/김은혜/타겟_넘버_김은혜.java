package week06_dfs_bfs.김은혜;

// n개의 음이 아닌 정수들로(순서 고정) 타겟 넘버를 만드는(+ or -) 방법의 수 리턴
public class 타겟_넘버_김은혜 {

    char[] kind={'+', '-'};
    char[] calc;
    int cnt=0;

    public int solution(int[] numbers, int target) {
        calc=new char[numbers.length];
        make(0, target, numbers);
        return cnt;
    }

    public void make(int n, int target, int[] numbers){
        if(n>=numbers.length){
            int result=0;

            for(int i=0; i<n; i++){
                int num=numbers[i];
                if(calc[i]=='-'){
                    num*=(-1);
                }

                result+=num;
            }

            if(result==target){
                cnt++;
            }
            return;
        }

        for(int i=0; i<2; i++){
            calc[n]=kind[i];
            make(n+1, target, numbers);
        }
    }
}
