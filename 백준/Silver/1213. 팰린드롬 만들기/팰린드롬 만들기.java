import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 65]++;
        
        int cnt = 0;
        for (int i : arr)
            if (i % 2 != 0) cnt++;
        if (cnt > 1) System.out.print("I'm Sorry Hansoo");
        else {
            StringBuilder b1 = new StringBuilder();
            StringBuilder b2 = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                String alphabet = String.valueOf((char) (i + 65));
                b1.append(alphabet.repeat(arr[i] / 2));
                b2.append(alphabet.repeat(arr[i] % 2));
            }
            System.out.print(b1.toString() + b2 + b1.reverse());
        }
    }
}