import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        int s = 1;
        int en = arr[n - 1];
        while (s <= en) {
            int mid = (s + en) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += Math.min(mid, arr[i]);
            if (sum <= m) s = mid + 1;
            else en = mid - 1;
        }
        System.out.print(en);
    }
}