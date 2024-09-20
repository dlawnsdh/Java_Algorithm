import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> word = new HashSet<>();
        int[] result = new int[2];
        word.add(words[0]);
        int num = 2;
        int turn = 1;
        for (int i = 1; i < words.length; i++) {
            if (!word.contains(words[i]) && words[i - 1].endsWith(String.valueOf(words[i].charAt(0)))) {
                word.add(words[i]);
                num++;   
            } else {
                result[0] = num;
                result[1] = turn;
                break;
            }
            if (num > n) {
                num = 1;
                turn++;
            }
        }
        return result;
    }
}