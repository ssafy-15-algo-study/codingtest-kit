import java.util.ArrayDeque;
import java.util.Queue;

import Solution.WordNode;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<WordNode> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new WordNode(begin, 0));

        while (!queue.isEmpty()) {
            WordNode curr = queue.poll();

            if (curr.word.equals(target)) {
                return curr.step;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && convert(curr.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new WordNode(words[i], curr.step + 1));
                }
            }
        }

        return 0;
    }

    private boolean convert(String w1, String w2) {
        int a = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                a++;
            }
            if (a > 1) return false;
        }
        return a == 1;
    }

    private static class WordNode {
        String word;
        int step;

        WordNode(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}