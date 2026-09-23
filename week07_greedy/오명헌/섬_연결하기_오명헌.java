package week7_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair implements Comparable<Pair>{
	int a;
	int b;
	int cost;
	
	public Pair (int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Pair o) {
		return this.cost - o.cost;
	}
}

public class 섬_연결하기_오명헌 {

	public static int[] uf;
	
	public static void union(int x, int y) {
		int X = find(x);
		int Y = find(y);
		
		uf[X] = Y;
	}
	
	public static int find(int x) {
		if (uf[x] == x) return x;
		
		uf[x] = find(uf[x]);
		return uf[x];
	}
	
	public int solution(int n, int[][] costs) {
        uf = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
        	uf[i] = i;
        }
        
        List<Pair> graph = new ArrayList<Pair>();
        
        for (int[] pair : costs) {
        	int a = pair[0];
        	int b = pair[1];
        	int cost = pair[2];
        	
        	graph.add(new Pair(a, b, cost));
        }
        
        Collections.sort(graph);
        
        int mst = 0;
        
        for (Pair pair : graph) {
        	int a = pair.a;
        	int b = pair.b;
        	int cost = pair.cost;
        	
        	if (find(a) == find(b)) {
        		continue;
        	}
        	
        	union(a, b);
        	mst += cost;
        }
        
        return mst;
    }
}





















