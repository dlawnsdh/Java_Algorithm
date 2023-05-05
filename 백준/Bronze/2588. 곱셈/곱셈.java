import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        String str = Integer.toString(b);
        for (int i = str.length() - 1; i >= 0; i--)
            System.out.println((str.charAt(i) - 48) * a);
        System.out.println(a * b);
    }
}