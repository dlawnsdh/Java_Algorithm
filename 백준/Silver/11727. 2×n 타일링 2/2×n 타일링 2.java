import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            if (i == 1) d[i] = 1;
            else if (i == 2) d[i] = 3;
            else d[i] = (d[i - 1] + 2 * d[i - 2]) % 10007;
        }
        System.out.print(d[n]);
    }
}