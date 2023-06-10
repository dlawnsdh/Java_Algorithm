import java.util.Scanner;
public class Main {
    static int div(int n) {
        if (n % 5 == 0)
            return n / 5;
        for (int i = n % 5; i < n; i += 5)
            if (i % 3 == 0)
                return i / 3 + (n - i) / 5;

        if (n % 3 == 0) return n / 3;
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(div(n));
    }
}