import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        long min = 1;
        long max = arr[k - 1];
        while (min <= max) {
            long mid = (min + max) / 2;
            long cnt = 0;
            for (int num : arr)
                cnt += num / mid;
            if (cnt >= n)
                min = mid + 1;
            else max = mid - 1;
        }
        System.out.print(max);
    }
}