import java.util.*;
import java.io.*;

public class Main {
    static boolean[] arr = new boolean[1000001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if (!arr[x] && !arr[y] && !arr[z])
                sum++;
            arr[x] = true;
            arr[y] = true;
            arr[z] = true;
        }
        System.out.print(sum);
    }
}