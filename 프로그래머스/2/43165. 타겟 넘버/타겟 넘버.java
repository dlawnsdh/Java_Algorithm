import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target, 0);
    }
    
    public int dfs(int[] numbers, int idx, int target, int sum) {
        if (idx == numbers.length) {
            if (sum == target) return 1;
            else return 0;
        }
        
        return dfs(numbers, idx + 1, target, sum + numbers[idx]) + dfs(numbers, idx + 1, target, sum - numbers[idx]);
    }
}