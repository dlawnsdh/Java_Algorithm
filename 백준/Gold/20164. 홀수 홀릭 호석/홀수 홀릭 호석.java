import java.util.*;
import java.io.*;

public class Main {
    static int max = 0;
    static int min = Integer.MAX_VALUE;

    static int countOdd(int n) {
        int count = 0;
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++)
            if ((s.charAt(i) - 48) % 2 != 0)
                count++;
        return count;
    }

    static void dfs(int n, int count) {
        if (n < 10) {
            max = Math.max(max, count + countOdd(n));
            min = Math.min(min, count + countOdd(n));
        } else if (n < 100) {
            int sum = n / 10 + n % 10;
            dfs(sum, count + countOdd(n));
        } else {
            String s = Integer.toString(n);
            for (int i = 0; i < s.length() - 2; i++)
                for (int k = i + 1; k < s.length() - 1; k++) {
                    int sum = Integer.parseInt(s.substring(0, i + 1));
                    sum += Integer.parseInt(s.substring(i + 1, k + 1));
                    sum += Integer.parseInt(s.substring(k + 1));
                    dfs(sum, count + countOdd(n));
                }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        dfs(n, 0);
        
        System.out.print(min + " " + max);
    }
}