import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        List<Integer> list = new ArrayList<>();
        String str = "";
        
        for (int i = 0; i < X.length(); i++) 
            arrX[X.charAt(i) - 48]++;
        for (int i = 0; i < Y.length(); i++) 
            arrY[Y.charAt(i) - 48]++;
        for (int i = 9; i >= 0; i--) 
            if (arrX[i] != 0 && arrY[i] != 0)
                str += Integer.toString(i).repeat(Math.min(arrX[i], arrY[i]));
        
        if (str.length() == 0)
            return "-1";
        else if (str.startsWith("0"))
            return "0";
        else return str;
    }
}