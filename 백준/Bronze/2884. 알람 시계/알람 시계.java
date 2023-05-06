import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int h = s.nextInt();
        int m = s.nextInt();

        if (m >= 45)
            System.out.printf("%d %d", h, m - 45);
        else {
            if (h == 0)
                System.out.printf("23 %d", 15 + m);
            else
                System.out.printf("%d %d", h - 1, 15 + m);
        }
    }
}