import java.util.*;
class Solution {
    boolean solution(String s) {
        if (s.charAt(0) == ')')
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty())
                stack.push(s.charAt(i));
            else {
                if (stack.peek() == '(' && s.charAt(i) == ')')
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}