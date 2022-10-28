class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int k = 0;
        for (int i = 3; i <= Math.sqrt(sum); i++)
            if (sum % i == 0 && (i - 2) * (sum / i - 2) == yellow)
                k = i;
        
        return new int[] {sum / k, k};
    }
}