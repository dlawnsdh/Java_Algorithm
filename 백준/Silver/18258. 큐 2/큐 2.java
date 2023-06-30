import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> q = new LinkedList<>();
        StringBuilder b = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            switch (arr[0]) {
                case "push":
                    q.add(arr[1]);
                    break;
                case "pop":
                    if (!q.isEmpty())
                        b.append(q.poll());
                    else b.append(-1);
                    b.append("\n");
                    break;
                case "size":
                    b.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty())
                        b.append(1);
                    else b.append(0);
                    b.append("\n");
                    break;
                case "front":
                    if (!q.isEmpty())
                        b.append(q.getFirst());
                    else b.append(-1);
                    b.append("\n");
                    break;
                case "back":
                    if (!q.isEmpty())
                        b.append(q.getLast());
                    else b.append(-1);
                    b.append("\n");
                    break;
            }
        }
        System.out.print(b); 
    }
}