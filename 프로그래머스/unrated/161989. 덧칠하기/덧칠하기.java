class Solution {
    public int solution(int n, int m, int[] section) {
        int k = section[section.length - 1] - section[0] + 1;
        if (m == 1)
            return section.length;
        else if (m >= k)
            return 1;
        else {
            int right = section[section.length - 1];
            int left = section[0];
            int cnt = 0;
            
            for (int i = 0; i < section.length; i++) {
                if (section[i] > left + m - 1) {
                    cnt++;
                    left = section[i];
                }
                else if (section[i] < right - m + 1) {
                    cnt++;
                    right = section[i];
                }
            }
            return cnt;
        }
    }
}