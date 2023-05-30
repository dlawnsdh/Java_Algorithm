import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int cnt = 0;
        for (int i = 0; i < discount.length - 9; i++) {
            String[] arr = Arrays.copyOfRange(discount, i, i + 10);
            Map<String, Integer> map = new HashMap<>();
            
            for (int k = 0; k < arr.length; k++) {
                if (!map.containsKey(arr[k]))
                    map.put(arr[k], 1);
                else map.put(arr[k], map.get(arr[k]) + 1);
            }
            
            int tmp = 0;
            for (int k = 0; k < want.length; k++) 
                if (map.containsKey(want[k]) && map.get(want[k]) == number[k])
                    tmp++;
            if (tmp == want.length)
                cnt++;
        }
        
        return cnt;
    }
}