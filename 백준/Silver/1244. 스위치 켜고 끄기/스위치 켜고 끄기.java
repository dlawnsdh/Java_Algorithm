import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++)
            arr[i] = Integer.parseInt(str.nextToken());
        int k = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
            
            if (gender == 1) {
                int t = 1;
                while (num * t <= n) {
                    if (arr[num * t] == 0) arr[num * t] = 1;
                    else arr[num * t] = 0;
                    t++;
                }
            } else {
                int start = num - 1;
                int end = num + 1;
                while (start > 0 && end < arr.length) {
                    if (arr[start] != arr[end]) break;
                    start--;
                    end++;
                }
                start++;
                end--;
                for (int j = start; j <= end; j++) {
                    if (arr[j] == 0) arr[j] = 1;
                    else arr[j] = 0;   
                }
            }
        }
        
        for (int i = 1; i < arr.length; i++) {
            bw.write(arr[i] + " ");
            if (i % 20 == 0) bw.newLine();
        }
        bw.flush();
    }
}