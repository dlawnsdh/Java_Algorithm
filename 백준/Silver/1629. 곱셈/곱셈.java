import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt();
        System.out.print(func(a, b, c));
    }
    
    public static long func(int a, int b, int c) {
        if (b == 1) return a % c;
        long k = func(a, b / 2, c);
        k = k * k % c;
        if (b % 2 == 0) return k;
        else return k * a % c;
    }
}