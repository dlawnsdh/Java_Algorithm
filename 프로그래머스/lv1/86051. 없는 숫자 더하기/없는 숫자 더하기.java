import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int sum = (int) Arrays.stream(numbers).sum();
        return 45 - sum;
    }
}