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
        
        Arrays.sort(arr);
        int[] result = new int[2];
        int s = 0;
        int e = n - 1;
        int min = Integer.MAX_VALUE;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (min > Math.abs(arr[s] + arr[e])) {
                min = Math.abs(arr[s] + arr[e]);
                result[0] = arr[s];
                result[1] = arr[e];
            }
            if (sum > 0) e--;
            else if (sum < 0) s++;
            else break;
        }
        System.out.print(result[0] + " " + result[1]);
    }
}