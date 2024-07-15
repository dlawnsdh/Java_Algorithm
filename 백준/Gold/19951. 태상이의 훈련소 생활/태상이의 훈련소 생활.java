import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] dist = new int[n + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a] += c;
            dist[b + 1] += -c;
        }
        for (int i = 1; i <= n; i++)
            dist[i] += dist[i - 1]; 
        for (int i = 1; i <= n; i++)
            arr[i] += dist[i];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(arr[i]).append(' ');
        System.out.print(sb);
    }
}