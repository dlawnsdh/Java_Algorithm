import java.util.*;
import java.io.*;

public class Main {
    static class Process implements Comparable<Process> {
        int id;
        int time;
        int priority;
        
        Process(int id, int t, int p) {
            this.id = id;
            this.time = t;
            this.priority = p;
        }
        
        @Override
        public int compareTo(Process o) {
            if (this.priority == o.priority)
                return this.id - o.id;
            return o.priority - this.priority;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Process> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            pq.add(new Process(id, t, p));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            if (pq.isEmpty())
                break;
            Process cur = pq.poll();
            sb.append(cur.id).append('\n');
            if (cur.time > 1) 
                pq.add(new Process(cur.id, cur.time - 1, cur.priority - 1));
        }
        System.out.print(sb);
    }
}