import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList();
        int result = 0;
        while(n > 2) {
            list.add(n % 3);
            n /= 3;
        }
        list.add(n);
        
        for (int i = 0; i < list.size(); i++) {
            int k = list.size() - i - 1;
            if (list.get(i) != 0)
                result += Math.pow(3, k) * list.get(i);
        }
        return result;
    }
}