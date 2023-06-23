import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n + 1];

        if (n == 1 || n == 2)
            System.out.println(n);
        else {
            arr[1] = 1;
            arr[2] = 2;
            for (int i = 3; i <= n; i++)
                arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
            System.out.println(arr[n]);
        }
    }
} 