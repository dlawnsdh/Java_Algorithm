import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] arr = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) 
            for (int k = 0; k < targets[i].length(); k++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < keymap.length; j++) 
                    if (keymap[j].contains(Character.toString(targets[i].charAt(k)))) 
                        list.add(keymap[j].indexOf(targets[i].charAt(k)) + 1);
                
                if (list.isEmpty()) {
                    arr[i] = -1;
                    break;
                }
                else {
                    Collections.sort(list);
                    arr[i] += list.get(0);
                }
            }  
        return arr;
    }
}