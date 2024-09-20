import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] rest = IntStream.range(0, progresses.length)
            .map(i -> {
                int r = 100 - progresses[i];
                return r % speeds[i] == 0 ? r / speeds[i] : r / speeds[i] + 1;
            })
            .toArray();
        
        List<Integer> l = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int max = rest[0];
        st.push(rest[0]);
        for (int i = 1; i < rest.length; i++) {
            if (st.isEmpty() || max >= rest[i])
                st.push(rest[i]);
            else {
                int cnt = 0;
                l.add(st.size());
                while (!st.isEmpty())
                    st.pop();
                st.push(rest[i]);
                max = rest[i];
            }
        }
        l.add(st.size());
        return l.stream().mapToInt(Integer::intValue).toArray();
    }
}