import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        String str = "";
        for (int i = 0; i < participant.length; i++) {
            if (i >= completion.length) {
                str = participant[i];
                break;
            }
            if (!participant[i].equals(completion[i])) {
                str = participant[i];
                break;
            }
        }
        return str;
    }
}