import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer[]> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            l.add(new Integer[] {Integer.parseInt(arr[0]), Integer.parseInt(arr[1])});
        }
        
        Collections.sort(l, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[1].equals(o2[1]))
                    return o1[0].compareTo(o2[0]);
                return o1[1].compareTo(o2[1]);
            }
        });
        
        int cnt = 1;
        int index = 0;
        for (int i = index + 1; i < n; i++)
            if (l.get(index)[1] <= l.get(i)[0]) {
                cnt++;
                index = i;
            }
        
        System.out.print(cnt);
    }
}