class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            int root = (int) Math.sqrt(i);
            if (root * root == i)
                sum -= i;
            else sum += i;
        }
        return sum;
    }
}