import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int k = 0; k < i + 1; k++)
                arr[i][k] = sc.nextInt();
        System.arraycopy(arr[n - 1], 0, d[n - 1], 0, n);

        for (int i = n - 2; i > - 1; i--)
            for (int k = 0; k < i + 1; k++)
                d[i][k] += arr[i][k] + Math.max(d[i + 1][k], d[i + 1][k + 1]);
        System.out.print(d[0][0]);
    }
}