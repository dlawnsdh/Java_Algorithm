import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        Set<String> s = new HashSet<>();
        
        for (int i = 0; i < phone_book.length; i++) {
            for (int k = 1; k <= phone_book[i].length(); k++) {
                if (s.contains(phone_book[i].substring(0, k))) 
                    return false;
            }
            s.add(phone_book[i]);
        }
        return true;
    }
}