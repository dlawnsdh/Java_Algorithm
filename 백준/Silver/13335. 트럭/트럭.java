import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            trucks[i] = Integer.parseInt(st.nextToken());
        
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++)
            bridge.add(0);
        int totalWeight = 0;
        int time = 0;
        for (int truck : trucks) {
            totalWeight -= bridge.poll();
            time++;
            while (totalWeight + truck > l) {
                totalWeight -= bridge.poll();
                bridge.add(0);
                time++;
            }
            bridge.add(truck);
            totalWeight += truck;
        }
        while (!bridge.isEmpty()) {
            bridge.poll();
            time++;
        }
        System.out.print(time);
    }
}