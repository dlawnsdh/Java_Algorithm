import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        return (int) Arrays.stream(skill_trees).filter(skill_tree -> {
            int[] arr = new int[26];
            for (int i = 0; i < skill_tree.length(); i++) {
                char c = skill_tree.charAt(i);
                if (skill.contains(String.valueOf(c))) {
                    if (skill.startsWith(String.valueOf(c))) 
                        arr[c - 65]++;
                    else if (arr[skill.charAt(skill.indexOf(c) - 1) - 65] == 0)
                        return false;
                    else arr[c - 65]++;
                }
            }
            return true;
        }).count();
    }
}
