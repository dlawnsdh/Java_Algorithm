import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer[]> q = new LinkedList<>();
        int n = Integer.parseInt(sc.nextLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int k = 0; k < n; k++)
                map[i][k] = s.charAt(k) - 48;
        }
        
        int cnt = 0;
        List<Integer> l =  new ArrayList<>();
        for (int i = 0; i < n; i++) 
            for (int k = 0; k < n; k++)
                if (map[i][k] == 1 && !visited[i][k]) {
                    q.add(new Integer[] {i, k});
                    int sum = 0;
                    while (!q.isEmpty()) {
                        int x = q.peek()[0];
                        int y = q.peek()[1];
                        q.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = x + dx[j];
                            int ny = y + dy[j];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if (map[nx][ny] == 0 || visited[nx][ny]) continue;
                            q.add(new Integer[] {nx, ny});
                            visited[nx][ny] = true;
                            sum++;
                        }
                    }
                    if (sum == 0) sum = 1;
                    l.add(sum);
                    cnt++;
                }
        System.out.println(cnt);
        Collections.sort(l);
        l.forEach(System.out::println);
    }
}