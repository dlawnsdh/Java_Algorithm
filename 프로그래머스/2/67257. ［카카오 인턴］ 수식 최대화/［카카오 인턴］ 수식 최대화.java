import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Solution {
    String[][] operators = {{"*", "+", "-"}, {"*", "-", "+"}, {"+", "*", "-"}, {"+", "-", "*"}, {"-", "+", "*"}, {"-", "*", "+"}};
    
    public long solution(String expression) {
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile("\\d+|\\D");
        Matcher m = p.matcher(expression);    
        while (m.find()) 
            list.add(m.group());

        long max = 0;
        for (String[] op : operators) {
            List<String> l = new ArrayList<>(list);
            for (String operator : op)
                l = calculate(l, operator).stream().collect(Collectors.toList());
            max = Math.max(max, Math.abs(Long.parseLong(l.get(0))));
        }
        return max;
    }
    
    public Stack<String> calculate(List<String> l, String operator) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < l.size(); i++) {
            if (!st.isEmpty() && st.peek().equals(operator))
                st.push(calculateWithOperator(st.pop(), st.pop(), l.get(i)));
            else st.push(l.get(i));
        }
        return st;
    }
                            
    public String calculateWithOperator(String op, String n1, String n2) {
        return switch(op) {
            case "+" -> String.valueOf(Long.parseLong(n1) + Long.parseLong(n2));
            case "-" -> String.valueOf(Long.parseLong(n1) - Long.parseLong(n2));
            case "*" -> String.valueOf(Long.parseLong(n1) * Long.parseLong(n2));
            default -> "-1";
        };
    }
}