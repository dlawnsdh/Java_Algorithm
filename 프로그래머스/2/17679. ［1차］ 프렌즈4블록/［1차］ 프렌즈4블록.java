import java.util.*;

class Solution {
    char[][] map;
    
    boolean is2x2Block(int x, int y) {
        if (map[x][y] == 'X')
            return false;
        if (map[x][y] == map[x + 1][y] && map[x][y] == map[x][y + 1] && map[x][y] == map[x + 1][y + 1])
            return true;
        return false;
    }
    
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        for (int i = 0; i < board.length; i++)
            map[i] = board[i].toCharArray();
        
        int count = 0;
        while (true) {
            Queue<int[]> q = new LinkedList<>();
            boolean isRemoved = false;
            for (int i = 0; i < m - 1; i++)
                for (int k = 0; k < n - 1; k++)
                    if (is2x2Block(i, k)) {
                        q.add(new int[] {i, k});
                        q.add(new int[] {i + 1, k});
                        q.add(new int[] {i, k + 1});
                        q.add(new int[] {i + 1, k + 1});
                        isRemoved = true;
                    }
            if (!isRemoved) break;
            
            while (!q.isEmpty()) {
                if (map[q.peek()[0]][q.peek()[1]] != 'X') {
                    map[q.peek()[0]][q.peek()[1]] = 'X';
                    count++;
                }
                q.poll();
            }
            
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < m; k++)
                    if (map[k][i] != 'X')
                        sb.append(map[k][i]);
                for (int k = 0; k < m - sb.length(); k++)
                    map[k][i] = 'X';
                for (int k = m - sb.length(); k < m; k++)
                    map[k][i] = sb.charAt(k - (m - sb.length()));
            }
        }
        return count;
    }
}