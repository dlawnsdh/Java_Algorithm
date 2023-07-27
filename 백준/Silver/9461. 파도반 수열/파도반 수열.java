import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            long[] d = new long[n];
            for (int i = 0; i < n; i++) {
                if (i == 0 || i == 1 || i == 2) d[i] = 1;
                else if (i == 3 || i == 4) d[i] = 2;
                else d[i] = d[i - 1] + d[i - 5];
            }
            System.out.println(d[n - 1]);
        }
    }
}