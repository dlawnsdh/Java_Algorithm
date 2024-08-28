import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int count = 0;
    static int l, r, x;
    
    static void dfs(int st, int d, int k) {
        if (d == k) {
            int sum = 0;
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++)
                if (visited[i]) {
                    sum += arr[i];
                    min = Math.min(min, arr[i]);
                    max = Math.max(max, arr[i]);
                }
            if (sum >= l && sum <= r && max - min >= x)
                count++;
            return;
        }
        
        for (int i = st; i < arr.length; i++) 
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, d + 1, k);
                visited[i] = false;
            }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        for (int i = 2; i <= n; i++)
            dfs(0, 0, i);
        System.out.print(count);
    }
}