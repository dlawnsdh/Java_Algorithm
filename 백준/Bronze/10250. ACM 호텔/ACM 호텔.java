import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int h = s.nextInt();
            int w = s.nextInt();
            int n = s.nextInt();

            if (h >= n)
                System.out.println(n + "01");
            else {
                int r = n % h;
                int k = n / h;
                if (r == 0) {
                    if (k < 10)
                        System.out.println(h + "0" + k);
                    else
                        System.out.printf("%d%d\n", h, k);
                }
                else {
                    if (k < 9)
                        System.out.println(r + "0" + (k + 1));
                    else
                        System.out.printf("%d%d\n", r, k + 1);
                }
            }
        }
    }
}