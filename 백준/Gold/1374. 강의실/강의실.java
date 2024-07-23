import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i][0] = s;
            arr[i][1] = e;
        }
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
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