import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = n - 1; i > -1; i--)
            arr[i] = Integer.parseInt(br.readLine());
        
        int sum = 0;
        for (int i = 0; i < n - 1; i++) 
            if (arr[i + 1] >= arr[i]) {
                sum += Math.abs(arr[i + 1] - arr[i]) + 1;
                arr[i + 1] = arr[i] - 1;
            }
        System.out.print(sum);
    }
}