import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int j = 0; j < t; j++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String[] arr = s.substring(1, s.length() - 1).split(",");
            LinkedList<String> l = new LinkedList<>();
            for (int i = 0; i < n; i++)
                l.add(arr[i]);
            
            StringBuilder b = new StringBuilder();
            boolean flag = true;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    flag = !flag;
                } else if (l.isEmpty()) {
                    b.append("error");
                    break;
                } else if (flag) {
                    l.poll();
                } else l.pollLast();
            }
            
            if (b.toString().equals("error")) System.out.println(b);
            else {
                b.append('[');
                if (flag) {
                    while (!l.isEmpty())
                        b.append(l.poll()).append(',');
                } else {
                    while (!l.isEmpty())
                        b.append(l.pollLast()).append(',');
                }
                if (b.charAt(b.length() - 1) == ',')
                    b.deleteCharAt(b.length() - 1);
                b.append(']');
                System.out.println(b);
            }
        }
    }
}