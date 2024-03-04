class Solution {
    public int[] result = new int[2];
    
    public int[] solution(int[][] arr) {
        func(arr, arr.length, 0, 0);
        return result;
    }
    
    public void func(int[][] arr, int n, int x, int y) {
        if (n == 1) {
            result[arr[x][y]]++;
            return;
        }
        
        boolean flag = true;
        for (int i = x; i < x + n; i++)
            for (int k = y; k < y + n; k++)
                if (arr[x][y] != arr[i][k]) {
                    flag = false;
                    break;
                }
        if (flag) {
            result[arr[x][y]]++;
            return;
        }
        
        n /= 2;
        func(arr, n, x, y);
        func(arr, n, x + n, y);
        func(arr, n, x, y + n);
        func(arr, n, x + n, y + n);
    }
}