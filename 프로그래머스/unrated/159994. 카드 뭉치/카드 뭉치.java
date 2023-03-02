import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for (int i = 0; i < goal.length; i++) {
            String str = goal[i];
            boolean flag = false;
            for (int k = 0; k < cards1.length; k++) 
                if (cards1[k].equals(str)) {
                    list1.add(str);
                    flag = true;
                    break;
                }
            if (!flag) {
                for (int k = 0; k < cards2.length; k++)
                    if (cards2[k].equals(str)) {
                        list2.add(str);
                        break;
                    }
            }
        }
        
        if (list1.size() > 1) 
            for (int i = 0; i < list1.size(); i++) 
                if (!list1.get(i).equals(cards1[i]))
                    return "No";
        if (list2.size() > 1)
            for (int i = 0; i < list2.size(); i++) 
                if (!list2.get(i).equals(cards2[i]))
                    return "No";
        return "Yes";
    }
}