class Solution {
    public int[] solution(int n) {
        int[] result = new int[n * (n + 1) / 2];
        int[][] arr = new int[n + 1][n + 1];
        int num = 1; // 저장되는 수
        int idx = 1; // 아래로 내려가면서 채워지는 수들의 col 값, 계속 +1됨
        int st = 1;  // 삼각형 꼭짓점의 row 값 계속, -2 됨
        int en = n;  // 오른쪽으로 채워지는 수들의 row 값, 계속 -1 됨
        int k = 0;   // 위로 올라가면서 채워지는 수들의 col 패딩 값, 계속 +1 됨
        
        while (st <= en) {
            // 아래로 내려가면서 수 채우기
            for (int i = st; i <= en; i++)
                arr[i][idx] = num++;
            // 오른쪽으로 이동하면서 수 채우기
            for (int i = idx + 1; i <= en - k; i++)
                arr[en][i] = num++;
            // 위로 올라가면서 수채우기
            for (int i = en - 1; i > st; i--)
                arr[i][i - k] = num++;
            
            st += 2;
            en--;
            k++;
            idx++;
        }
        
        int index = 0;
        for (int i = 1; i <= n; i++) 
            for (int j = 1; j <= i; j++)
                result[index++] = arr[i][j];
        return result;
    }
}