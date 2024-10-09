import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        int s = 1;
        int en = arr[n - 1];
        int max = 0;
        while (s <= en) {
            int mid = (s + en) / 2;
            int count = 0;
            for (int i = 0; i < n; i++)
                count += arr[i] / mid;
            if (count >= m){
                s = mid + 1;
                max = Math.max(max, mid);
            } else en = mid - 1;
        }
        System.out.print(max);
    }
}