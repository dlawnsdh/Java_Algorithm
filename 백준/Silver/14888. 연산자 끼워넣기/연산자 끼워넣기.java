import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> l = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> op = new ArrayList<>(); // ex) + 가 2개 - 가 1개 * 가 2개 / 가 3개 주어진다면 op는 [0, 0, 1, 2, 2, 3, 3, 3] 으로 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            l.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int t = Integer.parseInt(st.nextToken());
            for (int k = 0; k < t; k++)
                op.add(i);
        }
       
        dfs(op.stream().mapToInt(Integer::intValue).toArray(), new int[op.size()], new boolean[op.size()], 0);
        System.out.println(max);
        System.out.print(min);
    }
    
    // 주어진 배열을 바탕으로 순열을 생성 ex) 6개의 연산자가 주어지면 6개 전부를 뽑는 순열 생성
    static void dfs(int[] arr, int[] result, boolean[] visited, int d) {
        if (d == arr.length) {
            max = Math.max(max, calculate(result));
            min = Math.min(min, calculate(result));
            return;
        }

        for (int i = 0; i < arr.length; i++)
            if (!visited[i]) {
                visited[i] = true;
                result[d] = arr[i];
                dfs(arr, result, visited, d + 1);
                visited[i] = false;
            }
    }
    
    static int calculate(int[] op) {
        Stack<Integer> s = new Stack<>();
        s.push(l.get(0));
        for (int i = 0; i < op.length; i++) {
            s.push(operation(s.pop(), op[i], l.get(i + 1)));
        }
        return s.pop();
    }

    static int operation(int n1, int o, int n2) {
        if (o == 0) return n1 + n2;
        else if (o == 1) return n1 - n2;
        else if (o == 2) return n1 * n2;
        else return n1 / n2;
    }
}