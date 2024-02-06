import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr1[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr2[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr1[i] * arr2[n - i - 1];
        System.out.print(sum);
    }
}