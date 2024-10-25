import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        long s = 1;
        long e = Integer.MAX_VALUE;
        while (s <= e) {
            long mid = (s + e) / 2;
            long sum = mid * (mid + 1) / 2;
            for (int i = 1; i < n; i++) {
                if (mid - (arr[i] - arr[i - 1] - 1) >= 0) {
                    long tmp = mid - (arr[i] - arr[i - 1] - 1);
                    sum += (mid + tmp) * (mid - tmp + 1) / 2;
                } else sum += mid * (mid + 1) / 2;
            }
            
            if (sum >= k) e = mid - 1;
            else s = mid + 1;
        }
        System.out.print(s);
    }
}