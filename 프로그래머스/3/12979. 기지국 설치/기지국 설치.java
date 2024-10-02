import java.util.*;

class Solution {
    int add(int a, int b) {
        return a % b == 0 ? a / b : a / b + 1;
    }
    
    public int solution(int n, int[] stations, int w) {
        int d = 2 * w + 1;
        int st = 1;
        int total = 0;
        for (int i = 0; i < stations.length; i++) {
            if (stations[i] - w - st > 0)
                total += add(stations[i] - w - st, d);
            st = stations[i] + w + 1;
        }
        if (n > stations[stations.length - 1] + w) 
            total += add(n - (stations[stations.length - 1] + w), d);
        return total;
    }
}