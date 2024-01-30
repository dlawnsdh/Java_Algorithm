class Solution {
    public long solution(int n) {
        long[] dist = new long[2001];
        dist[1] = 1;
        dist[2] = 2;
        for (int i = 3; i <= n; i++)
            dist[i] = (dist[i - 1] + dist[i - 2]) % 1234567;
        return dist[n];
    }
}