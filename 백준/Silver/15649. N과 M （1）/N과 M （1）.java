import java.util.*;
import java.io.*;

public class Main {
    public static void combination(int[] arr, boolean[] visited, int n, int m, int k) {
        if (k == m) {
            for (int i = 0; i < k; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++)
            if (!visited[i]) {
                visited[i] = true;
                arr[k] = i;
                combination(arr, visited, n, m, k + 1);
                visited[i] = false;
            }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        combination(new int[n + 1], new boolean[n + 1], n, m, 0);
    }
}