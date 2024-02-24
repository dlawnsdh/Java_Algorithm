import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder b = new StringBuilder();
        Arrays.stream(numbers).boxed().sorted((i1, i2) -> {
            String s1 = Integer.toString(i1) + Integer.toString(i2);
            String s2 = Integer.toString(i2) + Integer.toString(i1);
            return -Integer.compare(Integer.parseInt(s1), Integer.parseInt(s2)); 
        }).forEach(b::append);
        
        return Arrays.stream(numbers)
            .filter(i -> i == 0)
            .count() == numbers.length ? "0" : b.toString();
    }
}