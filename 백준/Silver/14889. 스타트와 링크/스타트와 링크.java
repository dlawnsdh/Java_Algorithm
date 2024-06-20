import java.util.*;
import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;
    
    static void dfs(int d, int r, int st) {
        if (d == r) {
            int[] g1 = new int[arr.length / 2];
            int[] g2 = new int[arr.length / 2];
            int idx1 = 0;
            int idx2 = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) g1[idx1++] = i;
                else g2[idx2++] = i;
            }
            int sum1 = 0;
            int sum2 = 0;
            for (int i : g1)
                for (int k : g1)
                    sum1 += arr[i][k];
            for (int i : g2)
                for (int k : g2)
                    sum2 += arr[i][k];
            min = Math.min(min, Math.abs(sum1 - sum2));
            return;
        }
        
        for (int i = st; i < arr.length; i++) {
            visited[i] = true;
            dfs(d + 1, r, i + 1);
            visited[i] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++)
                arr[i][k] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, n / 2, 0);
        System.out.print(min);
    }
}