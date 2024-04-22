import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
        
        return kruskal(costs, parent);
    }
    
    public int kruskal(int[][] arr, int[] parent) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) 
            if (find(parent, arr[i][0]) != find(parent, arr[i][1])) {
                sum += arr[i][2];
                union(parent, arr[i][0], arr[i][1]);
            }  
        return sum;
    }
    
    public int find(int[] parent, int n) {
        if (parent[n] == n) return n;
        return find(parent, parent[n]);
    }
    
    public void union(int[] parent, int n, int m) {
        n = find(parent, n);
        m = find(parent, m);
        if (n < m) parent[m] = n;
        else parent[n] = m;
    }
}