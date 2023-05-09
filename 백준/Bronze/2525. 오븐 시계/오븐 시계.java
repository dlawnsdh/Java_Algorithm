import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int h = s.nextInt();
        int m = s.nextInt();
        int n = s.nextInt();

        if (m + n < 60)
            System.out.printf("%d %d", h, m + n);
        else {
            int tmp = h + ((m + n) / 60);
            if (tmp < 24)
                System.out.printf("%d %d", tmp, (m + n) % 60);
            else
                System.out.printf("%d %d", tmp - 24, (m + n) % 60);
        }
    }
}