import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        if (arr.length == 1)
            return arr;
        
        Stack<Integer> stack = new Stack();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++)
            if (stack.peek() != arr[i])
                stack.push(arr[i]);
        
        List<Integer> list = new ArrayList();
        while (!stack.isEmpty()) 
            list.add(stack.pop());
        Collections.reverse(list);
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
}