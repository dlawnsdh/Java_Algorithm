import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        
        if (n == 1 || n == 2) System.out.print(n);
        else {
            d[0] = 1; d[1] = 2;
            for (int i = 2; i < n; i++) 
                d[i] = (d[i - 1] + d[i - 2]) % 10007;
            System.out.print(d[n - 1]);    
        }
    }
}