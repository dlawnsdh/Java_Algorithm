import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.fill(d, 1);
        
        for (int i = 1; i < n; i++) 
            for (int k = 0; k < i; k++)
                if (arr[k] < arr[i])
                    d[i] = Math.max(d[i], d[k] + 1);
        Arrays.sort(d);
        System.out.print(d[n - 1]);
    }
}