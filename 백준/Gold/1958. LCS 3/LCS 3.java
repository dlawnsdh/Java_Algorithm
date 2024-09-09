import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        int[][][] dp = new int[a.length() + 1][b.length() + 1][c.length() + 1];
        
        for (int i = 0; i < a.length(); i++)
            for (int k = 0; k < b.length(); k++)
                for (int j = 0; j < c.length(); j++) {
                    if (a.charAt(i) == b.charAt(k) && a.charAt(i) == c.charAt(j))
                        dp[i + 1][k + 1][j + 1] = dp[i][k][j] + 1;
                    else dp[i + 1][k + 1][j + 1] = Math.max(dp[i][k + 1][j + 1], Math.max(dp[i + 1][k][j + 1], dp[i + 1][k + 1][j]));
                }
        System.out.print(dp[a.length()][b.length()][c.length()]);
    }
}