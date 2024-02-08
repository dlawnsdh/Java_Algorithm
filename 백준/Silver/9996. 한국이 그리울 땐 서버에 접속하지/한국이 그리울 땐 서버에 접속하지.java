import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] pattern = br.readLine().split("\\*");
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() < pattern[0].length() + pattern[1].length()) {
                System.out.println("NE");
                continue;
            }
            if (s.startsWith(pattern[0]) && s.endsWith(pattern[1]))
                System.out.println("DA");
            else System.out.println("NE");
        }
    }
}