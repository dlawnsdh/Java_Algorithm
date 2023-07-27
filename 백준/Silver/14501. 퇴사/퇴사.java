import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n + 1][2];
        int[][] d = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        d[1][0] = arr[1][0];
        d[1][1] = arr[1][1];
        for (int i = 2; i < n + 1; i++) {
            if (arr[i][0] + i > n + 1) continue;
            d[i][0] = arr[i][0];
            d[i][1] = arr[i][1];
            for (int k = 1; k < i; k++)
                if (arr[k][0] + k <= i && d[k][0] + arr[i][0] < n + 1) {
                    d[i][0] = d[k][0] + arr[i][0];
                    d[i][1] = Math.max(d[k][1] + arr[i][1], d[i][1]);
                }
        }
        int max = 0;
        for (int i = 1; i < n + 1; i++)
            if (d[i][0] < n + 1)
                max = Math.max(d[i][1], max);
        System.out.print(max);
    }
}