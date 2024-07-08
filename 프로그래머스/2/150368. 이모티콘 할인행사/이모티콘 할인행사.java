class Solution {
    int[] goal = {0, 0};
    
    // result : 이모티콘 개수만큼 10% ~ 40% 중 한 개로 이루어진 중복 순열
    // visited : 길이가 4인 10% ~ 40% 의 방문 여부를 담는 배열 
    void dfs(int[][] users, int[] emoticons, double[] result, boolean[] visited, int d, int r) {
        if (d == r) {
            int[] arr = calculate(users, emoticons, result);
            if (goal[0] < arr[0] || (goal[0] == arr[0] && goal[1] < arr[1])) {
                goal[0] = arr[0];
                goal[1] = arr[1];
            }
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            visited[i] = true;
            result[d] = (i + 1) * 0.1;
            dfs(users, emoticons, result, visited, d + 1, r);
            visited[i] = false;
        }
    }
    
    int[] calculate(int[][] users, int[] emoticons, double[] discountRate) {
        int member = 0;
        int sale = 0;
        for (int i = 0; i < users.length; i++) {
            int sum = 0;
            for (int k = 0; k < discountRate.length; k++)
                if (users[i][0] <= discountRate[k] * 100) 
                    sum += emoticons[k] - emoticons[k] * discountRate[k];
            if (sum >= users[i][1])
                member++;
            else sale += sum;
        }
        
        return new int[] {member, sale};
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(users, emoticons, new double[emoticons.length], new boolean[4], 0, emoticons.length);
        return goal;
    }
}