import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1000002];
        StringTokenizer st;
        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s]++;
            arr[e + 1]--;
            max = Math.max(max, e);
        }
        for (int i = 1; i <= max; i++)
            arr[i] += arr[i - 1];
        
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int t = Integer.parseInt(st.nextToken());
            sb.append(Math.max(arr[t], 0)).append('\n');
        }
        System.out.print(sb);
    }
}