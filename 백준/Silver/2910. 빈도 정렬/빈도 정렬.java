import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[] nums = br.readLine().split(" ");
        
        Map<Integer, int[]> m = new HashMap<>();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            int[] tmp = m.getOrDefault(Integer.parseInt(nums[i]), new int[] {0, n - i});
            tmp[0]++;
            m.put(Integer.parseInt(nums[i]), tmp);
        }
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(nums[i]);
            arr[i][1] = m.get(arr[i][0])[0];
            arr[i][2] = m.get(arr[i][0])[1];
        }
        Arrays.sort(arr, (arr1, arr2) -> {
            if (arr1[1] == arr2[1]) return Integer.compare(arr1[2], arr2[2]);
            else return Integer.compare(arr1[1], arr2[1]);
        });
        for(int i = n - 1; i >= 0; i--)
            System.out.print(arr[i][0] + " ");
    }
}