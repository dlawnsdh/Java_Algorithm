import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations.length; i++)
            h = Math.max(h, Math.min(citations.length - i, citations[i]));
        return h;
    }
}