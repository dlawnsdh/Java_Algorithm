class Solution {
    public int[] solution(int brown, int yellow) {
        int h = 0;
        int w = yellow;
        while (h <= w) {
            h++;
            w = yellow / h;
            if (yellow % h != 0) 
                continue;
            if (w * 2 + h * 2 + 4 == brown) 
                break;
        }
        return new int[] {w + 2, h + 2};
    }
}