class Solution {
    public int solution(int n) {
        int[] d = new int[100001];
        d[1] = 1; d[2] = 1;
        for (int i = 2; i <= n; i++)
            d[i] = (d[i - 1] + d[i - 2]) % 1234567;
        return d[n];
    }
}