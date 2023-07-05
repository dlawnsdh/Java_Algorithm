import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        
        int cnt = 0;
        for (int i = n - 1; i > -1; i--) {
            cnt += k / arr[i];
            k %= arr[i];
            if (k == 0)
                break;
        }
        
        System.out.print(cnt);
    }
}