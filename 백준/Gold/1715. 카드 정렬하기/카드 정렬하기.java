import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            pq.add(Integer.parseInt(br.readLine()));
        int sum = 0;
        while (pq.size() > 1) {
            int tmp = pq.poll() + pq.poll();
            sum += tmp;
            pq.add(tmp);
        }
        System.out.print(sum);
    }
} 