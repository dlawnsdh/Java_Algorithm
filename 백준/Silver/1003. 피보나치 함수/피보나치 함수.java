import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] d = new int[41];
        d[0] = 0; d[1] = 1; d[2] = 1;
        for (int i = 3; i <= 40; i++)
            d[i] = d[i - 1] + d[i - 2];
        for (int i = 0; i < n; i++) {
            int k = s.nextInt();
            if (k == 0) System.out.println("1 0");
            else if (k == 1) System.out.println("0 1");
            else System.out.printf("%d %d\n", d[k - 1], d[k]);
        }
    }
}