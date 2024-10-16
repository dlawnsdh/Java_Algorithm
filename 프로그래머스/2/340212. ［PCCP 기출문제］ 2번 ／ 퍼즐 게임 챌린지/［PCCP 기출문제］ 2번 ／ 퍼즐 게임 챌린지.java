class Solution {
    long solveTime(int[] d, int[] t, int level) {
        long sum = t[0];
        for (int i = 1; i < d.length; i++) {
            if (d[i] <= level) 
                sum += t[i];
            else sum += (d[i] - level) * (t[i] + t[i - 1]) + t[i];
        }
        return sum;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int st = 1; // 최소 숙련도
        int en = 100000; // 최대 숙련도
        while (st <= en) {
            int mid = (st + en) / 2;
            if (solveTime(diffs, times, mid) > limit) // 시간안에 못풀면 레벨업
                st = mid + 1;
            else en = mid - 1;
        }
        return st;
    }
}