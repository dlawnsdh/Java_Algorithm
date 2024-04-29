import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        
        Map<String, PriorityQueue<Integer>> m = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < q; i++) {
            String[] arr = br.readLine().split(" ");
            if (arr[0].equals("1")) {
                PriorityQueue<Integer> pq;
                if (m.containsKey(arr[1]))
                    pq = m.get(arr[1]);
                else pq = new PriorityQueue<>((a, b) -> b - a);
                
                for (int k = 3; k < arr.length; k++)
                    pq.add(Integer.parseInt(arr[k]));
                m.put(arr[1], pq);
            } else {
                if (m.containsKey(arr[1])) {
                    PriorityQueue<Integer> pq = m.get(arr[1]);
                    int idx = Integer.parseInt(arr[2]);
                    
                    while(idx > 0 && !pq.isEmpty()) {
                        sum += pq.poll();
                        idx--;
                    }
                    m.put(arr[1], pq);
                }
            }
        }
        System.out.print(sum);
    }
}