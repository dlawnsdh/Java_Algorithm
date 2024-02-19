import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    
    public static void func(int a, int b, int n) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append('\n');
            return;
        }
        func(a, 6 - a - b, n - 1);
        sb.append(a).append(" ").append(b).append('\n');
        func(6 - a - b, b, n - 1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((int) Math.pow(2, n) - 1);
        func(1, 3, n);
        System.out.print(sb);
    }
}