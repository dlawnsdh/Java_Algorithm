import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < numbers.length - 1; i++)
            for (int k = i + 1; k < numbers.length; k++) 
                list.add(numbers[i] + numbers[k]);
        list = list.stream().distinct().sorted().collect(Collectors.toList());
        int[] result = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
}
