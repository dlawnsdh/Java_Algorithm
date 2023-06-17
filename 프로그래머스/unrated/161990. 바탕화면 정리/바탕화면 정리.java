class Solution {
    public int[] solution(String[] wallpaper) {
        int[] arr = new int[4];
        int lx = wallpaper.length;
        int rx = 0;
        int ly = wallpaper[0].length();
        int ry = 0;
        
        for (int i = 0; i < wallpaper.length; i++)
            for (int k = 0; k < wallpaper[i].length(); k++) 
                if (wallpaper[i].charAt(k) == '#') {
                    if (i < lx) 
                        lx = i;
                    if (i + 1 > rx) 
                        rx = i + 1;
                    if (k < ly) 
                        ly = k;
                    if (k + 1 > ry) 
                        ry = k + 1;
                }
        arr[0] = lx;
        arr[1] = ly;
        arr[2] = rx;
        arr[3] = ry;
        
        return arr;
    }
}