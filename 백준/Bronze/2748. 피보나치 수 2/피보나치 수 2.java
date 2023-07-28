import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            if (i == 0) d[i] = 0;
            else if (i == 1) d[i] = 1;
            else d[i] = d[i - 1] + d[i - 2];
        }
        System.out.print(d[n]);
    }
}