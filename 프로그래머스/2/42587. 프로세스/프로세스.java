import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++)
            q.add(new int[] {i, priorities[i]});
        
        int cnt = 0;
        int idx = priorities.length;
        while (idx != location) {
            int[] max = q.stream()
                .max((arr1, arr2) -> Integer.compare(arr1[1], arr2[1]))
                .orElse(new int[] {0, 0});
            int[] cur = q.poll();
            if (cur[1] < max[1]) q.add(cur);
            else {
                idx = cur[0];
                cnt++;
            }
        }
        return cnt;
    }
}