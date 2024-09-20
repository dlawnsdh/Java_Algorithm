import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0;
        int idx = 0;
        for (int i = people.length - 1; i >= 0; i--) {
            if (people[idx] + people[i] <= limit) 
                idx++;
            cnt++;
            if (idx >= i) break;
        }
        return cnt;
    }
}