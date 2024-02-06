import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> l = new ArrayList<>();
        List<int[]> dp = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[i];
            for (int k = 0; k < i; k++)
                arr[k] = Integer.parseInt(st.nextToken());
            l.add(arr);
            dp.add(new int[i]);
        }
        
        dp.set(0, l.get(0));
        for (int i = 0; i < n - 1; i++) {
            int[] arr1 = dp.get(i);
            int[] arr2 = dp.get(i + 1);
            for (int k = 0; k < arr1.length; k++) {
                arr2[k] = Math.max(arr2[k], arr1[k] + l.get(i + 1)[k]);
                arr2[k + 1] = Math.max(arr2[k + 1], arr1[k] + l.get(i + 1)[k + 1]);
            }                          
            dp.set(i + 1, arr2);
        }
        Arrays.sort(dp.get(n - 1));
        System.out.print(dp.get(n - 1)[n - 1]);
    }
}