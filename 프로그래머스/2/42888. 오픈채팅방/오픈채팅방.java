import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> m = new HashMap<>();
        for (String s : record) {
            String[] msg = s.split(" ");
            if (msg[0].equals("Enter") || msg[0].equals("Change"))
                m.put(msg[1], msg[2]);
        }
        
        ArrayList<String> l = new ArrayList<>();
        for (String s : record) {
            String[] msg = s.split(" ");
            if (msg[0].equals("Enter"))
                l.add(m.get(msg[1]) + "님이 들어왔습니다.");
            else if (msg[0].equals("Leave"))
                l.add(m.get(msg[1]) + "님이 나갔습니다.");
        }
        return l.toArray(new String[0]);
    }
}