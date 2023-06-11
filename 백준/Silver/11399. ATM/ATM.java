import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();

        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0 ; i < n; i++) 
            for (int k = 0; k < i + 1; k++) 
                sum += arr[k];
        
        System.out.print(sum);
    }
}