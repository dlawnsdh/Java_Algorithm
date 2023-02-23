class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        if (max % min == 0)
            return new int[] {min, max};
        
        while (min != 0) {
            int tmp = max % min;
            max = min;
            min = tmp;
        }
        answer[0] = max;
        answer[1] = n * m / max;
        return answer;
    }
}