import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> tower = new Stack<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            if (tower.isEmpty())
                tower.push(h);
            else {
                while (!tower.isEmpty() && tower.peek() <= h)
                    tower.pop();
                sum += tower.size();
                tower.push(h);
            }
        }
        System.out.println(sum);
    }
}