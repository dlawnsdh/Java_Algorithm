import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        d[0] = arr[0];
        for (int i = 1; i < n; i++)
            d[i] += Math.max(0, d[i - 1]) + arr[i];
        Arrays.sort(d);
        System.out.print(d[n - 1]);
    }
}