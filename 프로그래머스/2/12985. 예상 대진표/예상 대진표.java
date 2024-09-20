class Solution {
    public int solution(int n, int a, int b) {
        int round = 1;
        while (Math.abs(a - b) > 1 || Math.max(a, b) % 2 != 0) {
            a = a % 2 == 0 ? a / 2 : a / 2 + 1;
            b = b % 2 == 0 ? b / 2 : b / 2 + 1;
            round++;
        }
        return round;
    }
}