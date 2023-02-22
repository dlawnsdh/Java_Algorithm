import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[] {-1};
        
        int index = 0;
        int min = arr[0];
        List<Integer> list = new ArrayList();
        
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        list.remove(index);
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
}