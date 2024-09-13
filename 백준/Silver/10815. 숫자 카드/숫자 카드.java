import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            int s = 0;
            int e = n - 1;
            boolean flag = false;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (arr[mid] == k) {
                    flag = true;
                    break;
                } else if (arr[mid] > k) 
                    e = mid - 1;
                else s = mid + 1;
            }
            if (flag) sb.append(1);
            else sb.append(0);
            sb.append(' ');
        }
        System.out.print(sb);
    }
}