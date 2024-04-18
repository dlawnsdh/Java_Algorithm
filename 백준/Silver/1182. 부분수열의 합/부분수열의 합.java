import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    static int s;
    static int[] arr;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= n; i++)
            dfs(0, 0, i);
        System.out.print(count);
    }
    
    static void dfs(int st, int d, int r) {
        if (d == r) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++)
                if (visited[i])
                    sum += arr[i];
            if (sum == s) count++;
            return;
        }
        
        for (int i = st; i < arr.length; i++) {
            visited[i] = true;
            dfs(i + 1, d + 1, r);
            visited[i] = false;
        }
    }
}