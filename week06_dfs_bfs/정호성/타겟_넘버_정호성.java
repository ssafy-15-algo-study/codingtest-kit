class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int idx, int cur) {
        if (idx == numbers.length) {
            return cur == target ? 1 : 0;
        }
        
        int n1 = dfs(numbers, target, idx + 1, cur + numbers[idx]);
        int n2 = dfs(numbers, target, idx + 1, cur - numbers[idx]);

        return n1 + n2;
    }
}