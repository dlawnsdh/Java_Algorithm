import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] correct = new int[3];
        int i = 0;
        int k = 0;
        int j = 0;
        int index = 0;
        
        while (index < answers.length) {
            if (i == arr1.length)
                i = 0;
            if (k == arr2.length)
                k = 0;
            if (j == arr3.length)
                j = 0;
            
            if (arr1[i] == answers[index])
                correct[0]++;
            if (arr2[k] == answers[index])
                correct[1]++;
            if (arr3[j] == answers[index])
                correct[2]++;
            
            index++;
            i++;
            k++;
            j++;
        }
        
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int n = 0; n < correct.length; n++)
            if (correct[n] > max) 
                max = correct[n];
        for (int n = 0; n < correct.length; n++)
            if (correct[n] == max)
                list.add(n + 1);
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}