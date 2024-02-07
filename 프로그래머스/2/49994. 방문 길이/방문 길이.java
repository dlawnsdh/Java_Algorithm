import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int[] from = {0, 0};
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
            
        for (int i = 0; i < dirs.length(); i++) {
            int[] to = switch (dirs.charAt(i)) {
                case 'U' -> new int[] {from[0], from[1] + 1};
                case 'D' -> new int[] {from[0], from[1] - 1};
                case 'L' -> new int[] {from[0] - 1, from[1]};
                case 'R' -> new int[] {from[0] + 1, from[1]};   
                default -> new int[] {from[0], from[1]};
            };
            if (to[0] < -5 || to[0] > 5 || to[1] < -5 || to[1] > 5) 
                continue;
            String fromTo = String.format("%d%d%d%d", from[0], from[1], to[0], to[1]); 
            String toFrom = String.format("%d%d%d%d", to[0], to[1], from[0], from[1]); 
            if (!visited.contains(fromTo) && !visited.contains(toFrom))
                visited.add(fromTo);
            from = new int[] {to[0], to[1]};
        }
        return visited.size();
    }
}