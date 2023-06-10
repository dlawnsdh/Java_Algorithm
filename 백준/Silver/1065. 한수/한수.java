import java.util.*;

public class Main {
    public static boolean def(int n) {
        String s = Integer.toString(n);
        int tmp = s.charAt(0) - s.charAt(1);
        for (int i = 1; i < s.length() - 1; i++)
            if (tmp != s.charAt(i) - s.charAt(i + 1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        if (n < 100)
            System.out.print(n);
        else {
            int cnt = 0;
            for (int i = 100; i <= n; i++) {
                if (def(i)) cnt++;
            }
            System.out.print(cnt + 99);
        }
    }
}