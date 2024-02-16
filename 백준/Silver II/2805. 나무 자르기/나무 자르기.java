import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        long start = 0;
        long end = 2000000000;
        long max = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = Arrays.stream(arr)
                .filter(i -> i > mid)
                .mapToLong(i -> i - mid)
                .sum();
            if (sum < m) end = mid - 1;
            else {
                max = mid;
                start = mid + 1;
            }
        }
        System.out.print(max);
    }
}