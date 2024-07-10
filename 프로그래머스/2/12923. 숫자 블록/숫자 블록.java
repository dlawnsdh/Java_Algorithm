class Solution {
    int find(int n) {
        int num = 1;
        int max = 0;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) {
                if (n / i <= 10000000) 
                    max =  Math.max(max, n / i);
                else max =  Math.max(max, i);
            }
        return Math.max(max, num);
    }
    
    public int[] solution(long begin, long end) {
        int[] arr = new int[(int) (end - begin) + 1];
        for (int i = (int) begin; i <= (int) end; i++) {
            if (i == 1) continue;
            arr[i - (int) begin] = find(i);
        }
        return arr;
    }
}