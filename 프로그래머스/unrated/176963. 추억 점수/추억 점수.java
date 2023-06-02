import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] arr = new int[photo.length];
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < name.length; i++)
            m.put(name[i], yearning[i]);
        
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int k = 0; k < photo[i].length; k++) {
                if (m.containsKey(photo[i][k]))
                    sum += m.get(photo[i][k]);
            }
            arr[i] = sum;
        }
        
        return arr;
    }
}