import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] d = new int[12];
            d[1] = 1; d[2] = 2; d[3] = 4;
            if (n > 3) {
                for (int j = 4; j <= n; j++)
                    for (int k = j - 3; k < j; k++)
                        d[j] += d[k];
            }
            System.out.println(d[n]);
        }
    }
}