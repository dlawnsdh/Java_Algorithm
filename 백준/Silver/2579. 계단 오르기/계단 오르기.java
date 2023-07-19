import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] d = new int[301];
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        
        d[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            if (i == 2) d[2] = arr[1] + arr[2];
            else if (i == 3) 
                d[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
            else 
                d[i] = Math.max(arr[i - 1] + d[i - 3], d[i - 2]) + arr[i];
        }
        System.out.print(d[n]);
    }
}