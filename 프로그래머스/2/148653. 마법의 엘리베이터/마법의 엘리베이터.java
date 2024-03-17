import java.util.*;

class Solution {
    public int solution(int storey) {
        return dfs(storey, ("0" + Integer.toString(storey)).length() - 1, 0);
    }
    
    public int dfs(int n, int idx, int cnt) {
        int[] arr = Arrays.stream(("0" + Integer.toString(n)).split(""))
            .mapToInt(Integer::parseInt)
            .toArray();
        if (idx == 0)
            return Math.min(arr[1], 10 - arr[1]) + cnt;
        
        int t = (int) Math.pow(10, arr.length - idx);
        return Math.min(
            dfs(n - (t / 10 * arr[idx]), idx - 1, cnt + arr[idx]), 
            dfs(n + t - (t / 10 * arr[idx]), idx - 1, cnt + (10 - arr[idx]))
        );
    }
}