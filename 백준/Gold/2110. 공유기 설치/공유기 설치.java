import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(s.nextToken());
        int c = Integer.parseInt(s.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        int st = 1;
        int en = arr[n - 1] - arr[0];
        int max = 0;
        while (st <= en) {
            int mid = (st + en) / 2;
            int count = 1;
            int idx = 0;
            while (idx < n) {
                boolean flag = false;
                for (int i = idx + 1; i < n; i++)
                    if (arr[i] - arr[idx] >= mid) {
                        idx = i;
                        count++;
                        flag = true;
                        break;
                    }
                if (!flag) idx++;
            }
            if (count >= c) {
                max = mid;
                st = mid + 1;
            } else en = mid - 1;
        }
        System.out.print(max);
    }
}