import java.util.*;

class Solution {
    int dfs(int target, int[] numbers, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) return 1;
            else return 0;
        }
        return dfs(target, numbers, idx + 1, sum + numbers[idx]) 
            + dfs(target, numbers, idx + 1, sum - numbers[idx]);
    }
    
    public int solution(int[] numbers, int target) {
        return dfs(target, numbers, 0, 0);
    }
}