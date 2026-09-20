package week06_dfs_bfs.김은혜;

import java.util.ArrayDeque;

// begin -> target 가장 짧은 변환 과정(변환 못하면 0 반환)
// 변환: 한 번에 한 개의 알파벳만 가능 + words에 있는 단어로만 변환 가능
class Word{
    String str;
    int cnt;

    Word(String str, int cnt){
        this.str=str;
        this.cnt=cnt;
    }
}

public class 단어_변환_김은혜 {

    ArrayDeque<Word> deq=new ArrayDeque<>();
    boolean[] visit;

    public int solution(String begin, String target, String[] words) {
        visit=new boolean[words.length];
        deq.add(new Word(begin, 0));
        int result=0;

        while(!deq.isEmpty()){
            Word w=deq.poll();
            if(w.str.equals(target)){
                result=w.cnt;
                break;
            }

            for(int i=0; i<words.length; i++){
                if(visit[i]) continue;

                int diff=0;
                for(int j=0; j<words[i].length(); j++){
                    if(words[i].charAt(j)!=w.str.charAt(j)) diff++;
                    if(diff>1) break;
                }

                if(diff==1){
                    visit[i]=true;
                    deq.add(new Word(words[i], w.cnt+1));
                }
            }
        }

        return result;
    }
}
