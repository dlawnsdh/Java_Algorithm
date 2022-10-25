import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuffer bf = new StringBuffer("");
        
        if (n <= k && n != 1) return 1;

        while (n >= k) {
            int rest = n % k;
            n /= k;
            bf.append(rest);
            if (n <= k)
                bf.append(n);
        }

        String changed = bf.reverse().toString();
        String[] str = changed.split("0");
        ArrayList<Long> list = new ArrayList<>(); 
        
        for (int i = 0; i < str.length; i++)
            if (!str[i].isEmpty())
                list.add(Long.parseLong(str[i]));

        for (int i = 0; i < list.size(); i++) {
            long m = list.get(i);
            int cnt = 0;
            if (m != 1) {
                for (long j = 2; j <= Math.sqrt(m); j++)
                    if (m % j == 0)
                        cnt++;
                if (cnt == 0)
                    answer++;
            }
        }
        return answer;
    }
}