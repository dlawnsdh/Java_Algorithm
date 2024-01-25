import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] route = new int[n + 1];
        
        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1] + 1;
            route[i] = i - 1;
            if (i % 2 == 0 && arr[i] > arr[i / 2] + 1) {
                arr[i] = arr[i / 2] + 1;
                route[i] = i / 2;   
            }
            if (i % 3 == 0 && arr[i] > arr[i / 3] + 1) {
                arr[i] = arr[i / 3] + 1; 
                route[i] = i / 3;   
            }
        }
        
        System.out.println(arr[n]);
        StringBuilder b = new StringBuilder();
        while (n > 0) {
            b.append(n).append(" ");
            n = route[n];
        }
        System.out.print(b);
    }
}