class Solution {
    public int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > maxX)
                maxX = sizes[i][0];
            if (sizes[i][1] > maxY)
                maxY = sizes[i][1];
        }
        
        int max = Math.max(maxX, maxY);
        int min = Math.min(maxX, maxY);
        if (min == maxX) {
            for (int i = 0; i < sizes.length; i++) 
                if (sizes[i][0] > sizes[i][1]) {
                    int tmp = sizes[i][1];
                    sizes[i][1] = sizes[i][0];
                    sizes[i][0] = tmp;
                }
            min = 0;
            for (int i = 0; i < sizes.length; i++)
                if (min < sizes[i][0])
                    min = sizes[i][0];
        }
        else {
            for (int i = 0; i < sizes.length; i++) 
                if (sizes[i][0] < sizes[i][1]) {
                    int tmp = sizes[i][1];
                    sizes[i][1] = sizes[i][0];
                    sizes[i][0] = tmp;
                }
            min = 0;
            for (int i = 0; i < sizes.length; i++)
                if (min < sizes[i][1])
                    min = sizes[i][1];
        }
        return max * min;
    }
}