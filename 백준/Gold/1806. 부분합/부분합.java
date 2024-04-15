import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(t.nextToken());
        int s = Integer.parseInt(t.nextToken());
        int[] arr = new int[n];
        t = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(t.nextToken());
        
        int min = Integer.MAX_VALUE;
        int en = 0;
        int sum = arr[0];
        for (int st = 0; st < n; st++) {
            while (en < n && sum < s) {
                en++;
                if (en != n) sum += arr[en];
            }
            if (en == n) break;
            min = Math.min(min, en - st + 1);
            sum -= arr[st];
        }
        if (min == Integer.MAX_VALUE) System.out.print(0);
        else System.out.print(min);
    }
}