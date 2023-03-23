class Solution {
    public int[] solution(int[] prices) {
        int[] arr = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            int t = 0;
            for (int k = i + 1; k < prices.length; k++) {
                t++;
                if (prices[i] > prices[k]) break;
            }
            arr[i] = t;
        }
        return arr;
    }
}