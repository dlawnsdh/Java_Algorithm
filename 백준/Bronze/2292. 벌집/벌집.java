import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = 1;
        int idx = 1;
        int cnt = 1;
        while (k < n) {
            k += 6 * idx++;
            cnt++;
        }
        System.out.print(cnt);
    }
}