import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> s = new Stack<>();
        int cnt = k;
        for (int i = 0; i < number.length(); i++) {
            while (!s.isEmpty() && cnt > 0 && s.peek() < number.charAt(i) - 48) {
                s.pop();
                cnt--;    
            }
            if (s.size() < number.length() - k)
                s.push(number.charAt(i) - 48);
        }
        
        StringBuilder b = new StringBuilder();
        while (!s.isEmpty())
            b.append(s.pop());
        return b.reverse().toString();
    }
}