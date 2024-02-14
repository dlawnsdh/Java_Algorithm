import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<int[]> s = new Stack<>();
        int[] arr = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            while (!s.isEmpty() && s.peek()[0] < numbers[i])
                arr[s.pop()[1]] = numbers[i];
            s.push(new int[] {numbers[i], i});
        }
        while (!s.isEmpty())
            arr[s.pop()[1]] = -1;
        
        return arr;
    }
}