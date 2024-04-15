import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        
        int min = Integer.MAX_VALUE;
        int idx = 0;
        int en = 0;
        while (idx < arr.length && en < arr.length) {
            if (arr[en] - arr[idx] < m) en++;
            else {
                min = Math.min(min, arr[en] - arr[idx]);
                idx++;
            }
        }
        System.out.print(min);
    }
}