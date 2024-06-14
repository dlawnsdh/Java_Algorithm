import java.util.*;

class Solution {
    public int bfs(String[] place) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for (int i = 0; i < 5; i++)
            for (int k = 0; k < 5; k++)
                if (place[i].charAt(k) == 'P') {
                    LinkedList<int[]> q = new LinkedList<>();
                    boolean[][] visited = new boolean[5][5];
                    visited[i][k] = true;
                    q.add(new int[] {i, k});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = cur[0] + dx[j];  
                            int ny = cur[1] + dy[j];   
                            int dist = Math.abs(i - nx) + Math.abs(k - ny);
                            if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
                            if (visited[nx][ny] || dist > 2 || place[nx].charAt(ny) == 'X') continue;
                            if (place[nx].charAt(ny) == 'P') 
                                return 0;
                            if (place[nx].charAt(ny) == 'O') {
                                visited[nx][ny] = true;
                                q.add(new int[] {nx, ny});
                            }
                        }
                    }
                }
        return 1;
    }
    
    public int[] solution(String[][] places) {
        int[] arr = new int[places.length];
        for (int i = 0; i < places.length; i++) 
            arr[i] = bfs(places[i]);
        return arr;
    }
}