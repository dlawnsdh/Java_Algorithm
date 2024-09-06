import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        int max = 0;
        for (int i = 0; i < a.length(); i++)
            for (int k = 0; k < b.length(); k++) {
                if (a.charAt(i) == b.charAt(k))
                    dp[i + 1][k + 1] = dp[i][k] + 1;
                else dp[i + 1][k + 1] = Math.max(dp[i][k + 1], dp[i + 1][k]);
                max = Math.max(max, dp[i + 1][k + 1]);
            }
        System.out.print(max);
    }
}