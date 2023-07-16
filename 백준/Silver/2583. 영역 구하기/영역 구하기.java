import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer[]> q = new LinkedList<>();
        int m = sc.nextInt(); int n = sc.nextInt(); int k = sc.nextInt();
        int[][] map = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt(); int y2 = m - sc.nextInt();
            int x2 = sc.nextInt(); int y1 = m - sc.nextInt();
            for (int a = y1; a < y2; a++)
                for (int b = x1; b < x2; b++)
                    map[a][b] = 1;
        }
        
        int cnt = 0;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (map[i][j] == 0 && !visited[i][j]) {
                    q.add(new Integer[] {i, j});
                    int sum = 0;
                    while (!q.isEmpty()) {
                        int x = q.peek()[1];
                        int y = q.peek()[0];
                        q.poll();
                        for (int h = 0; h < 4; h++) {
                            int nx = x + dx[h];
                            int ny = y + dy[h];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (map[ny][nx] == 1 || visited[ny][nx]) continue;
                            q.add(new Integer[] {ny, nx});
                            visited[ny][nx] = true;
                            sum++;
                        }
                    }
                    if (sum == 0) sum = 1;
                    l.add(sum);
                    cnt++;
                }
        System.out.println(cnt);
        Collections.sort(l);
        for (int i : l) System.out.print(i + " ");
    }
}