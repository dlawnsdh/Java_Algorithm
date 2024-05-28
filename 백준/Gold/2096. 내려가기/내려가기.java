import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][3];
        int[][] minDp = new int[n][3];
        int[][] maxDp = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 3; k++)
                arr[i][k] = Integer.parseInt(st.nextToken());
        }
        
        minDp[0][0] = arr[0][0]; minDp[0][1] = arr[0][1]; minDp[0][2] = arr[0][2];
        for (int i = 1; i < n; i++) {
            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + arr[i][0];
            minDp[i][1] = Math.min(minDp[i - 1][2], Math.min(minDp[i - 1][0], minDp[i - 1][1])) + arr[i][1];
            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + arr[i][2];
        }
        maxDp[0][0] = arr[0][0]; maxDp[0][1] = arr[0][1]; maxDp[0][2] = arr[0][2];
        for (int i = 1; i < n; i++) {
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + arr[i][0];
            maxDp[i][1] = Math.max(maxDp[i - 1][2], Math.max(maxDp[i - 1][0], maxDp[i - 1][1])) + arr[i][1];
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + arr[i][2];
        }
        
        System.out.print(Math.max(maxDp[n - 1][0], Math.max(maxDp[n - 1][1], maxDp[n - 1][2])) + " " + Math.min(minDp[n - 1][0], Math.min(minDp[n - 1][1], minDp[n - 1][2])));
    }
}