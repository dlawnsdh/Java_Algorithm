import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> s = new HashSet<>();
        int[] arr = new int[n + 1];
        
        int cnt = 1;
        s.add(words[0]);
        arr[1]++;
        for (int i = 1; i < words.length; i++) {
            cnt++;
            if (s.contains(words[i]) || words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                return new int[] {cnt, arr[cnt] + 1};
            }
            s.add(words[i]);
            arr[cnt]++;
            if (cnt == n) cnt = 0;
        }
        return new int[] {0, 0};
    }
}