import java.util.*;
import java.io.*;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
        Arrays.sort(arr);
        
        int m = Integer.parseInt(br.readLine());
        int[] have = new int[m];
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int s = 0;
            int e = n - 1;
            boolean flag = false;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (arr[mid] == num) {
                    flag = true;
                    break;
                } else if (arr[mid] > num) 
                    e = mid - 1;
                else s = mid + 1;
            }
            
            if (flag) sb.append(map.get(num));
            else sb.append(0);
            sb.append(' ');
        }
        System.out.print(sb);
    }
}