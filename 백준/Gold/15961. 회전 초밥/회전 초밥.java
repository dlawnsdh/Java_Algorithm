import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < k; i++)
            m.compute(arr[i], (key, v) -> v == null ? 1 : v + 1);
        int max = m.keySet().size();
        if (!m.containsKey(c))
            max++;
        for (int i = k; i < n * 2; i++) {
            m.compute(arr[i % n], (key, v) -> v == null ? 1 : v + 1);
            m.compute(arr[(i - k) % n], (key, v) -> v - 1);
            if (m.get(arr[(i - k) % n]) == 0)
                m.remove(arr[(i - k) % n]);
            int cnt = m.keySet().size();
            if (!m.containsKey(c))
                cnt++;
            if (max < cnt)
                max = cnt;
        }
        System.out.print(max);
    }
}