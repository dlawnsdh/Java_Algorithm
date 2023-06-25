import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = s.nextInt();
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        int sum = 0;
        for (int i = n - 1; i > -1; i--)
            sum += a[i] * b[n - 1 - i];
        
        System.out.print(sum);
    }
}