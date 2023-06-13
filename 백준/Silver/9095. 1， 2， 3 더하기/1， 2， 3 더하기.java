import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] d = new int[11];
        d[1] = 1; d[2] = 2; d[3] = 4;
        for (int i = 4; i < 11; i++)
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        for (int i = 0; i < n; i++) {
            int k = s.nextInt();
            System.out.println(d[k]);
        }
    }
}