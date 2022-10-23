import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int remove = 0;
        while (s.compareTo("1") != 0) {
            String[] str = s.split("");
            s = s.replace("0", "");
            remove += Arrays.stream(str).filter(i -> i.compareTo("0") == 0).mapToInt(i -> Integer.parseInt                             (i)).count();
            s = Integer.toBinaryString(s.length());
            cnt++;
        }
        answer[0] = cnt; answer[1] = remove;
        return answer;
    }
}