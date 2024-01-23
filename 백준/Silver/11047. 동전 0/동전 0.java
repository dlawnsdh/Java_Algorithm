import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int[] arr = new int[Integer.parseInt(nk[0])];
        for (int i = arr.length - 1; i > -1; i--)
            arr[i] = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        int idx = 0;
        int k = Integer.parseInt(nk[1]);
        while (k > 0) {
            cnt += k / arr[idx];
            k %= arr[idx++];
        }
        System.out.print(cnt);
    }
}