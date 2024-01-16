class Solution {
    public int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        dfs(k,  new int[dungeons.length], dungeons, 0);
        return max;
    }
    
    public void dfs(int k, int[] visited, int[][] dungeons, int sum) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] == 0 && k >= dungeons[i][0]) {
                visited[i] = 1;
                dfs(k - dungeons[i][1], visited, dungeons, sum + 1);
                visited[i] = 0;
            }
        }
        max = Math.max(max, sum);
    }
}