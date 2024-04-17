import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(t.nextToken());
        int m = Integer.parseInt(t.nextToken());
        t = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(t.nextToken());

        int sum = 0;
        int st = 0;
        int en = 0;
        int cnt = 0;
        while (st < arr.length) {
            while (en < arr.length && sum < m)
                sum += arr[en++];
            if (sum == m) cnt++;
            sum -= arr[st++];
        }
        System.out.print(cnt);
    }
}