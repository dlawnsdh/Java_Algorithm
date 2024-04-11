import java.util.*;

class Solution {
    public int[] solution(int n, long k) {         
        List<Integer> l = new ArrayList<>();
        long t = 1;
        for (int i = 1; i <= n; i++) {
            l.add(i);
            t *= i;
        }
        
        int[] arr = new int[n];
        int index = 0;
        while (!l.isEmpty()) {
            t /= n;    
            n--;
            
            int idx = k % t == 0 ? (int) (k / t) : (int) (k / t + 1);
            long r = k % t;
            arr[index++] = l.remove(idx - 1);
            
            if (r == 0) {
                for (int i = l.size() - 1; i >= 0; i--)
                    arr[index++] = l.get(i);
                break;
            }
            else k = r;
        }
        return arr;
    }
}