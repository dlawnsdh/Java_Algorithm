import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int[] knight = new int[number + 1];
        knight[1] = 1;
        
        for (int i = 2; i <= number; i++) {
            int cnt = 0;
            for (int k = 2; k < Math.sqrt(i); k++) 
                if (i % k == 0) 
                    cnt++;
            knight[i] = cnt * 2 + 2;
            int j = (int) Math.sqrt(i);
            if (j * j == i)
                knight[i] += 1;
        }
        
        for (int i = 2; i < knight.length; i++) 
            if (knight[i] > limit)
                knight[i] = power;
        return (int) Arrays.stream(knight).sum();
    }
}