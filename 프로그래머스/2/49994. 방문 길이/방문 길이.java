import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] from = {0, 0};
        int[] to = new int[2];
        Set<String> visited = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            if (dirs.charAt(i) == 'U' && from[1] + 1 < 6) {
                to = new int[] {from[0], from[1] + 1};
            } else if (dirs.charAt(i) == 'D' && from[1] - 1 > -6) {
                to = new int[] {from[0], from[1] - 1};
            } else if (dirs.charAt(i) == 'L' && from[0] - 1 > -6) {
                to = new int[] {from[0] - 1, from[1]};
            } else if (dirs.charAt(i) == 'R' && from[0] + 1 < 6) {
                to = new int[] {from[0] + 1, from[1]};
            } else to = new int[] {from[0], from[1]};
            
            StringBuilder fromTo = new StringBuilder();
            StringBuilder reverseFromTo = new StringBuilder();
            fromTo.append(from[0]).append(from[1]).append(to[0]).append(to[1]);
            reverseFromTo.append(to[0]).append(to[1]).append(from[0]).append(from[1]);
            if (from[0] == to[0] && from[1] == to[1])
                continue;
            if (!visited.contains(fromTo.toString()) && !visited.contains(reverseFromTo.toString()))
                visited.add(fromTo.toString());
            from = new int[] {to[0], to[1]};
        }
        return visited.size();
    }
}