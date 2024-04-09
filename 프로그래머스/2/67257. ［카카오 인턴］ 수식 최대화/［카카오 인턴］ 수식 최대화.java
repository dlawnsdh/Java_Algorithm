import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Solution {
    public long solution(String expression) {
        String[][] op = {{"*", "+", "-"}, {"*", "-", "+"}, {"+", "*", "-"}, {"+", "-", "*"}, {"-", "+", "*"}, {"-", "*", "+"}};
        long max = 0;
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile("\\d+|\\D");
        Matcher m = p.matcher(expression);    
        while (m.find()) 
            list.add(m.group());

        for (String[] o : op) {
            Stack<String> st = new Stack<>();
            List<String> l = new ArrayList<>();
            
            l = list;
            for (int i = 0; i < l.size(); i++) {
                if (!st.isEmpty() && st.peek().equals(o[0]))
                    st.push(calculate(st.pop(), st.pop(), l.get(i)));
                else st.push(l.get(i));
            }
            
            l = st.stream().collect(Collectors.toList());
            st.clear();
            for (int i = 0; i < l.size(); i++) {
                if (!st.isEmpty() && st.peek().equals(o[1]))
                    st.push(calculate(st.pop(), st.pop(), l.get(i)));
                else st.push(l.get(i));
            }
            
            l = st.stream().collect(Collectors.toList());
            st.clear();
            for (int i = 0; i < l.size(); i++) {
                if (!st.isEmpty() && st.peek().equals(o[2]))
                    st.push(calculate(st.pop(), st.pop(), l.get(i)));
                else st.push(l.get(i));
            }
            max = Math.max(max, Math.abs(Long.parseLong(st.peek())));
        }
        return max;
    }
                            
    public String calculate(String op, String n1, String n2) {
        return switch(op) {
            case "+" -> String.valueOf(Long.parseLong(n1) + Long.parseLong(n2));
            case "-" -> String.valueOf(Long.parseLong(n1) - Long.parseLong(n2));
            case "*" -> String.valueOf(Long.parseLong(n1) * Long.parseLong(n2));
            default -> "-1";
        };
    }
}