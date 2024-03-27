import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int a = arrayA[0];
        int b = arrayB[0];
        while (a > 0) {
            int cnt = 0;
            for (int i = arrayA.length - 1; i >= 0; i--) {
                if (arrayA[i] % a == 0) cnt++;
                else break;
            }
            if (cnt == arrayA.length) break;
            a--;
        }
        while (b > 0) {
            int cnt = 0;
            for (int i = arrayB.length - 1; i >= 0; i--) {
                if (arrayB[i] % b == 0) cnt++;
                else break;
            }
            if (cnt == arrayB.length) break;
            b--;
        }
        
        if (a == 1 && b == 1) return 0;
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i : arrayA)
            if (i % b == 0) {
                flag1 = true;
                break;
            }
        for (int i : arrayB)
            if (i % a == 0) {
                flag2 = true; 
                break;
            } 
        if (flag1 && flag2) return 0;
        return Math.max(a, b);
    }
}