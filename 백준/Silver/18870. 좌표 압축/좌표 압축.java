import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] tmp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp);
        
        Map<Integer, Integer> m = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < n; i++) 
            if (!m.containsKey(tmp[i]))
                m.put(tmp[i], rank++);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(m.get(arr[i])).append(' ');
        System.out.print(sb);
    }
}