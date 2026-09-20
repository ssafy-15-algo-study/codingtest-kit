package week06_dfs_bfs.김은혜;

// 항공권 정보 tickets 모두 사용해 방문하는 공항 경로 배열 리턴
// ICN 공항에서 시작
public class 여행경로_김은혜 {

    String[] course;
    boolean[] use;

    public String[] solution(String[][] tickets) {
        course=new String[tickets.length+1];
        use=new boolean[tickets.length];

        course[0]="ICN";
        useTicket(1, tickets);

        return course;
    }

    boolean useTicket(int n, String[][] tickets){
        if(n>tickets.length) return true;
        boolean[] check=new boolean[tickets.length];

        while(true){
            int idx=-1;
            for(int i=0; i<tickets.length; i++){
                if(use[i]) continue;
                if(!tickets[i][0].equals(course[n-1])) continue;
                if(check[i]) continue;

                if(idx<0 || tickets[idx][1].compareTo(tickets[i][1])>0){
                    idx=i;
                }
            }

            if(idx<0) return false;

            course[n]=tickets[idx][1];
            use[idx]=true;
            if(useTicket(n+1, tickets)){
                return true;
            }

            use[idx]=false;
            check[idx]=true;
        }
    }
}
