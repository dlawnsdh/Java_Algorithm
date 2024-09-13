import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            b[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(a);
        Arrays.sort(b);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int s = 0;
            int e = m - 1;
            boolean flag = true;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (b[mid] == a[i]) {
                    flag = false;
                    break;
                } else if (b[mid] > a[i])
                    e = mid - 1;
                else s = mid + 1;
            }
            if (flag) {
                sb.append(a[i]).append(' ');
                cnt++;
            }
        }
        if (sb.length() == 0) System.out.print(0);
        else {
            System.out.println(cnt);
            System.out.print(sb);
        }
    }
}