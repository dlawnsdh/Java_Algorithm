import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        Set<String> s = new HashSet<>();
        char[][] map = new char[m][n];
        for (int i = 0; i < board.length; i++)
            map[i] = board[i].toCharArray();
        
        boolean isDeleted = false;
        int total = 0;
        while (true) {
            for (int i = 0; i < m - 1; i++)
                for (int k = 0; k < n - 1; k++)
                    if (isBlock(map, i, k) && !isZero(map, i, k)) {
                        s.add(i + " " + k);
                        s.add((i + 1)  + " " + k);
                        s.add(i + " " + (k + 1));
                        s.add((i + 1) + " " + (k + 1));
                        isDeleted = true;
                    }
            if (!isDeleted) break;
            isDeleted = false;
            
            for (String xy : s) {
                String[] tmp = xy.split(" ");
                map[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] = '0';
                total++;
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
            s.clear();
        }
        return total;
    }
    
    public boolean isZero(char[][] map, int x, int y) {
        return map[x][y] == '0' || map[x + 1][y] == '0' || map[x][y + 1] == '0' || map[x + 1][y + 1] == '0';
    }
    
    public boolean isBlock(char[][] map, int x, int y) {
        return map[x][y] == map[x + 1][y] && map[x][y] == map[x][y + 1] && map[x][y] == map[x + 1][y + 1];
    }
}