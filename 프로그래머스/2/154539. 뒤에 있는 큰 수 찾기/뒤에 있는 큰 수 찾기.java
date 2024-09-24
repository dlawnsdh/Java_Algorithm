import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<int[]> st = new Stack<>();
        int[] arr = new int[numbers.length];
        Arrays.fill(arr, -1);
        for (int i = 0; i < numbers.length; i++) {
            while (!st.isEmpty() && st.peek()[0] < numbers[i]) {
                arr[st.peek()[1]] = numbers[i];
                st.pop();
            }
            st.push(new int[] {numbers[i], i});
        }
        return arr;
    }
}