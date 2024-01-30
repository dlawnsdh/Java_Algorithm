class Solution {
    public int[] solution(int brown, int yellow) {
        int cnt = brown - 4;
        int w = 0; int h = 0;
        for (int i = 1; i <= Math.sqrt(yellow); i++)
            if (yellow % i == 0 && cnt == i * 2 + yellow / i * 2) {
                w = yellow / i + 2;
                h = i + 2;
                break;
            }
        return new int[] {w, h};
    }
}