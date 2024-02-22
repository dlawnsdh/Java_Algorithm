import java.util.*;

class Solution {
    public List<int[]> l = new ArrayList<>();
    
    public void func(int a, int b, int n) {
        if (n == 1) {
            l.add(new int[] {a, b});
            return;
        }
        func(a, 6 - a - b, n - 1);
        l.add(new int[] {a, b});
        func(6 - a - b, b, n - 1);
    }
    
    public int[][] solution(int n) {
        func(1, 3, n);
        return l.toArray(int[][]::new);
    }
}