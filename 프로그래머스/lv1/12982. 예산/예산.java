import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        if (Arrays.stream(d).sum() <= budget)
            return d.length;
        
        int cnt = 0;
        int sum = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            if (sum + d[i] > budget) {
                cnt = i;
                break;
            }
            sum += d[i];
        }
        return cnt;
    }
}