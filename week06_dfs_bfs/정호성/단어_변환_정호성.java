import java.util.*;
import java.io.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        boolean[] visited = new boolean[n];
        
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{begin, 0});
        
        while (!q.isEmpty()) {
            Object[] cur = q.poll();
            String curWord = (String) cur[0];
            int cnt = (int) cur[1];

            if (curWord.equals(target)) {
                return cnt;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i] && canConvert(curWord, words[i])) {
                    visited[i] = true;
                    q.offer(new Object[]{words[i], cnt + 1});
                }
            }
        }
        
        return 0;
    }
    
    private boolean canConvert(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}