import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        while (t --> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            
            Deque<Integer> d = new LinkedList<>();
            int total = 0;
            int count = 0;
            for (int i = 0; i < m; i++) {
                d.add(arr[i]);
                total += d.peekLast();
            }
            if (total < k) count++;
      
            if (n != m) {
                for (int i = m; i < n + m - 1; i++) {
                    total -= d.poll();
                    d.add(arr[i % n]);
                    total += d.peekLast();
                    if (total < k)
                        count++;
                }    
            }
            System.out.println(count);
        }
    }
}
