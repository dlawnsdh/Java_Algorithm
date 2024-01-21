import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1 || n == 2) System.out.println(n);
            else if (n == 3) System.out.println(4);
            else {
                int[] arr = new int[n + 1];
                arr[1] = 1; arr[2] = 2; arr[3] = 4;
                for (int k = 4; k < n + 1; k++)
                    arr[k] = arr[k - 1] + arr[k - 2] + arr[k - 3];
                System.out.println(arr[n]);
            }
        }
    }
}