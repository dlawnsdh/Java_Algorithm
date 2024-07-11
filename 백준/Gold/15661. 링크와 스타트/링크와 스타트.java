import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    static void dfs(int d, int st, int r) {
        if (d == r) {
            calculate(r);
            return;
        }
        
        for (int i = st; i < arr.length; i++) {
            visited[i] = true;
            dfs(d + 1, i + 1, r);
            visited[i] = false;
        }
    }
    
    static void calculate(int r) {
        int idx1 = 0;
        int idx2 = 0;
        int[] arr1 = new int[r];
        int[] arr2 = new int[arr.length - r];
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) arr1[idx1++] = i;
            else arr2[idx2++] = i;
        }
        
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr1.length - 1; i++)
            for (int k = i + 1; k < arr1.length; k++)
                sum1 += arr[arr1[i]][arr1[k]] + arr[arr1[k]][arr1[i]];
        for (int i = 0; i < arr2.length - 1; i++)
            for (int k = i + 1; k < arr2.length; k++)
                sum2 += arr[arr2[i]][arr2[k]] + arr[arr2[k]][arr2[i]];
        min = Math.min(min, Math.abs(sum1 - sum2));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++)
                arr[i][k] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= n / 2; i++)
            dfs(0, 0, i);
        System.out.print(min);
    }
} 