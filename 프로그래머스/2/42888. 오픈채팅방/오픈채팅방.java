import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        Arrays.stream(record)
            .filter(r -> !r.startsWith("Leave"))
            .map(r -> r.split(" "))
            .forEach(arr -> users.compute(arr[1], (k, v) -> arr[2]));
        
        return Arrays.stream(record)
            .filter(r -> !r.startsWith("Change"))
            .map(r -> {
                String[] info = r.split(" ");
                String msg = "";
                if (info[0].equals("Enter"))
                    msg = String.format("%s님이 들어왔습니다.", users.get(info[1]));
                else if (info[0].equals("Leave"))
                    msg = String.format("%s님이 나갔습니다.", users.get(info[1]));
                return msg;
            })
            .toArray(String[]::new);
    }
}