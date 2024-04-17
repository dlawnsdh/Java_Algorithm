import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(t.nextToken());
        int d = Integer.parseInt(t.nextToken());
        int k = Integer.parseInt(t.nextToken());
        int c = Integer.parseInt(t.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        
        Map<Integer, Integer> m = new HashMap<>();
        int en = 0;
        int max = 0;
        int cnt = 0;
        for (int st = 0; st < n; st++) {
            while (en < arr.length * 2 && cnt < k) {
                m.compute(arr[en % n], (key, v) -> v == null ? 1 : v + 1);
                en++;
                cnt++;
            }
            if (m.containsKey(c)) max = Math.max(max, m.size());
            else max = Math.max(max, m.size() + 1);
            
            cnt--;
            m.compute(arr[st], (key, v) -> v - 1);
            if (m.get(arr[st]) == 0) m.remove(arr[st]);
        }
        System.out.print(max);
    }
}