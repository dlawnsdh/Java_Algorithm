import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n][3];
        for (int i = 0; i < n; i++) {
            int r = sc.nextInt(); int g = sc.nextInt(); int b = sc.nextInt();
            d[i] = new int[] {r, g, b};
        }
        
        for (int i = 1; i < n; i++) {
            d[i][0] += Math.min(d[i - 1][1], d[i - 1][2]);
            d[i][1] += Math.min(d[i - 1][0], d[i - 1][2]);
            d[i][2] += Math.min(d[i - 1][0], d[i - 1][1]);
        }
        int min = Math.min(Math.min(d[n - 1][0], d[n - 1][1]), d[n - 1][2]);
        System.out.print(min);
    }
}