import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        Stack<Integer> s = new Stack<>();
        int sum = 0;
        int len = 1;
        for (int i = 0; i < stations.length; i++) {
            sum += add(Math.max(0, stations[i] - len - w), w * 2 + 1);
            len = stations[i] + w + 1;
        }
        sum += add(Math.max(0, n - (stations[stations.length - 1] + w)), w * 2 + 1);
        return sum;
    }
    
    public int add(int n, int m) {
        if (n == 0) return 0;
        else if (n % m == 0) return n / m;
        else return n / m + 1;
    }
}