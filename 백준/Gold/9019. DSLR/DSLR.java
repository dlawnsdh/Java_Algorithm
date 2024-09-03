import java.util.*;
import java.io.*;

public class Main {
    static class Register {
        int num;
        String command;
        
        Register(int n, String c) {
            this.num = n;
            this.command = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        while (t --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10000];
            
            Queue<Register> q = new LinkedList<>();
            visited[a] = true;
            q.add(new Register(a, ""));
            while (!q.isEmpty()) {
                Register cur = q.poll();
                if (cur.num == b) {
                    sb.append(cur.command).append('\n');
                    break;
                }
                
                int d = (cur.num * 2) % 10000;
                int s = cur.num == 0 ? 9999 : cur.num - 1;
                int l = cur.num % 1000 * 10 + cur.num / 1000;
                int r = cur.num % 10 * 1000 + cur.num / 10;
                if (!visited[d]) {
                    visited[d] = true;
                    q.add(new Register(d, cur.command + "D"));
                }
                if (!visited[s]) {
                    visited[s] = true;
                    q.add(new Register(s, cur.command + "S"));
                }
                if (!visited[l]) {
                    visited[l] = true;
                    q.add(new Register(l, cur.command + "L"));
                }
                if (!visited[r]) {
                    visited[r] = true;
                    q.add(new Register(r, cur.command + "R"));
                }
            }
        }
        
        System.out.print(sb);
    }
}