class Solution {
    public long solution(int[] weights) {
        long count = 0;
        int[] arr = new int[4001];
        int[] origin = new int[1001];
        for (int w : weights) {
            count += arr[w * 2];
            count += arr[w * 3];
            count += arr[w * 4];
            if (origin[w] > 0) 
                count -= 2 * origin[w]; 
            arr[w * 2]++;
            arr[w * 3]++;
            arr[w * 4]++;
            origin[w]++;
        }
        return count;
    }
}