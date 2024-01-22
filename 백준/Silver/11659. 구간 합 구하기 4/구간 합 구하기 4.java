import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        int[] dp = new int[n];
        dp[0] = sc.nextInt();
        for (int i = 1; i < n; i++)
            dp[i] = sc.nextInt() + dp[i - 1];
        
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            if (start == 0) System.out.println(dp[end]);
            else System.out.println(dp[end] - dp[start - 1]);
        }
    }
}