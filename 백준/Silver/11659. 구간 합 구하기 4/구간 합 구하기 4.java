import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            d[i] = d[i - 1] + arr[i]; 
        }
        
        for (int k = 0; k < m; k++) {
            int i = sc.nextInt(); int j = sc.nextInt();
            System.out.println(d[j] - d[i - 1]);
        }
    }
}