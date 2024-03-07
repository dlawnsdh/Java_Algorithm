class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] result = new int[2];
        int en = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int st = 0; st < sequence.length; st++) {
            while (en < sequence.length && sum < k)
                sum += sequence[en++];
            if (sum == k && min > en - st + 1) {
                result[0] = st;
                result[1] = en - 1;
                min = en - st + 1;
            }
            sum -= sequence[st];
        }
        return result;
    }
}