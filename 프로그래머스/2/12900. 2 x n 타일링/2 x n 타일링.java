class Solution {
    public int solution(int n) {
        int[] dist = new int[n + 1];
        dist[1] = 1;
        dist[2] = 2;
        for (int i = 3; i <= n; i++)
            dist[i] = (dist[i - 1] + dist[i - 2]) % 1000000007;
        return dist[n];
    }
}