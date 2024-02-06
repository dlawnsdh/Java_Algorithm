import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (arr1, arr2) -> {
            if (arr1[1] == arr2[1])
                return Integer.compare(arr1[0], arr2[0]);
            else return Integer.compare(arr1[1], arr2[1]);
        });
        int end = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++)
            if (arr[i][0] >= end) {
                cnt++;
                end = arr[i][1];
            }
        System.out.print(cnt);
    }
}