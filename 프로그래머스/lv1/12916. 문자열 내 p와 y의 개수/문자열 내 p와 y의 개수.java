import java.util.*;

class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        String[] str = s.split("");
        System.out.println(s);
        long countP = Arrays.stream(str).filter(s1 -> s1.equals("p")).count();
        long countY = Arrays.stream(str).filter(s1 -> s1.equals("y")).count();
         System.out.println(countP);
         System.out.println(countY);
        return countP == countY;
    }
}