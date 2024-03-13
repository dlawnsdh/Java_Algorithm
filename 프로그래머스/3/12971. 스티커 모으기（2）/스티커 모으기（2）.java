import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        if (sticker.length == 1) return sticker[0];
        else if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        else if (sticker.length == 3) return Math.max(sticker[0] + sticker[2], sticker[1]);
        
        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
        
        // 1번을 뽑으면 마지막은 사용 못 하기 때문에 마지막 전까지 반복
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        for (int i = 2; i < sticker.length - 1; i++)
            dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);

        // 2번을 뽑으면 1번을 사용 못하기 때문에 dp 배열을 1부터 초기화하고 시작
        dp2[1] = sticker[1];
        dp2[2] = Math.max(sticker[1], sticker[2]);
        for (int i = 3; i < sticker.length; i++) 
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
     
        return Math.max(dp1[dp1.length - 2], dp2[sticker.length - 1]);
    }
}