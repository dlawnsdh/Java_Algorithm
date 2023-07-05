import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < n; i++) 
            max = Math.max(max, arr[i] * (n - i));

        System.out.print(max);
    }
}