import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> s = new HashSet<>();
        int x = 0;
        int y = 0;
        for (char op : dirs.toCharArray()) {
            int nx = x;
            int ny = y;
            if (op == 'U') ny++;
            else if (op == 'D') ny--;
            else if (op == 'R') nx++;
            else nx--;
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            String route = String.format("%d%d%d%d", x, y, nx, ny);
            String reverse = String.format("%d%d%d%d", nx, ny, x, y);
            s.add(route);
            s.add(reverse);
            x = nx;
            y = ny;
        }
        return s.size() / 2;
    }
}