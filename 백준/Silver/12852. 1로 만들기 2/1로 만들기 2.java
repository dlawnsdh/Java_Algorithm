import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 1];
        int[] p = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            p[i] = i - 1;
            if (i % 2 == 0) {
                if (d[i / 2] + 1 < d[i])
                    p[i] = i / 2;
                d[i] = Math.min(d[i / 2] + 1, d[i]);
            }
            if (i % 3 == 0) {
                if (d[i / 3] + 1 < d[i])
                    p[i] = i / 3;
                d[i] = Math.min(d[i / 3] + 1, d[i]);
            }
        }
        System.out.println(d[n]);
        int index = n;
        while (index > 0) {
            System.out.print(index + " ");
            index = p[index];
        }
    }
}