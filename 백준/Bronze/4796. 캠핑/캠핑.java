import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (true) {
            i++;
            int l = sc.nextInt(); int p = sc.nextInt(); int v = sc.nextInt();
            if (l == 0 && p == 0 && v == 0) break;
            
            int r = Math.min(v % p, l);
            System.out.printf("Case %d: %d\n", i, v / p * l + r);
        }
    }
}