import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        if (n == 1) System.out.print(1);
        else if (n == 2) System.out.print(3);
        else {
            int[] arr = new int[n];
            arr[0] = 1; arr[1] = 3;
            for (int i = 2; i < n; i++)
                arr[i] = (arr[i - 2] * 2 + arr[i - 1]) % 10007;
            System.out.print(arr[n - 1]);
        }
    }
}