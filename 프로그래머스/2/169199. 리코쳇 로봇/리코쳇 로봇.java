import java.util.*;

class Solution {
    public int solution(String[] board) {
        LinkedList<int[]> q = new LinkedList<>();
        int[][] dist = new int[board.length][board[0].length()];
        char[][] map = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++)
            for (int k = 0; k < board[i].length(); k++) {
                map[i][k] = board[i].charAt(k);
                dist[i][k] = -1;
                if (board[i].charAt(k) == 'R') {
                    q.add(new int[] {i, k});
                    dist[i][k] = 0;
                }
            }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (map[cur[0]][cur[1]] == 'G') {
                return dist[cur[0]][cur[1]];
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0];
                int ny = cur[1];
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || map[nx][ny] == 'D') break;
                }
                nx -= dx[i]; // while 문을 if 절에서 걸려서 빠져나올 때 nx, ny 가 dx[i], dy[i] 만큼 한 번더 더해져서 나오기 때문에
                ny -= dy[i]; // 이 두 절에서 한 번씩 빼준다.
                if (dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.add(new int[] {nx, ny});
            }
        }
        return -1;
    }
}