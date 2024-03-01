import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        LinkedList<XY> q = new LinkedList<>();
        char[][] map = new char[m][n];
        for (int i = 0; i < board.length; i++)
            map[i] = board[i].toCharArray();
        
        boolean isDeleted = false;
        int total = 0;
        while (true) {
            for (int i = 0; i < m - 1; i++)
                for (int k = 0; k < n - 1; k++)
                    if (isBlock(map, i, k) && !isZero(map, i, k)) {
                        q.add(new XY(i, k));
                        q.add(new XY(i + 1, k));
                        q.add(new XY(i, k + 1));
                        q.add(new XY(i + 1, k + 1));
                        isDeleted = true;
                    }
            if (!isDeleted) break;
            isDeleted = false;
            
            while (!q.isEmpty()) {
                XY xy = q.poll();
                if (map[xy.x][xy.y] != '0') {
                    map[xy.x][xy.y] = '0';
                    total++;
                }
            }
            
            for (int i = 0; i < n; i++) {
                StringBuilder b = new StringBuilder();
                int cnt = 0;
                for (int k = m - 1; k >= 0; k--) {
                    if (map[k][i] != '0') 
                        b.append(map[k][i]);
                    else cnt++;
                }
                for (int j = 0; j < cnt; j++)
                    b.append(0);
                for (int k = m - 1; k >= 0; k--)
                    map[k][i] = b.charAt(m - k - 1);
            }
            
        }
        return total;
    }
    
    public class XY {
        int x;
        int y;
        
        XY (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public boolean isZero(char[][] map, int x, int y) {
        return map[x][y] == '0' || map[x + 1][y] == '0' || map[x][y + 1] == '0' || map[x + 1][y + 1] == '0';
    }
    
    public boolean isBlock(char[][] map, int x, int y) {
        return map[x][y] == map[x + 1][y] && map[x][y] == map[x][y + 1] && map[x][y] == map[x + 1][y + 1];
    }
}