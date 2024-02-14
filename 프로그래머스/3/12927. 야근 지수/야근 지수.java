import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Arrays.sort(works);
        int sum = Arrays.stream(works).sum() - n;
        int idx1 = works.length; 
        int idx2 = 0; 
        long result = 0;
        
        if (sum <= 0) return result;
        while (idx1 > 0) {
            int t = sum / idx1 > works[idx2] ? works[idx2] : sum / idx1;
            result += t * t;
            sum -= t;
            idx1--;
            idx2++;
        }
        return result;
    }
}