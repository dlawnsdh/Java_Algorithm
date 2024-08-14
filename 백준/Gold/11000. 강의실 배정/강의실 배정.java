import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[i][0] = s;
            arr[i][1] = t;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) pq.add(arr[i][1]);
            else {
                if (pq.peek() > arr[i][0]) pq.add(arr[i][1]);
                else {
                    pq.poll();
                    pq.add(arr[i][1]);
                }
            }
        }
        System.out.print(pq.size());
    }
}