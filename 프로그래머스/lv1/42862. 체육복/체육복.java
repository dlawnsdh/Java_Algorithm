import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < reserve.length; i++)
            arr[reserve[i]]++;
        for (int i = 0; i < lost.length; i++)
            arr[lost[i]]--;
                
        for (int i = 0; i < lost.length; i++) 
          Outer : for (int k = 0; k < reserve.length; k++) 
                if (arr[reserve[k]] == 2 && arr[lost[i]] == 0) {
                    if (lost[i] - 1 == reserve[k] || lost[i] + 1 == reserve[k]) {
                        arr[reserve[k]]--;
                        arr[lost[i]]++;
                        break Outer;   
                    }
                }
        
        return Arrays.stream(arr).filter(i -> i > 0).map(i -> 1).sum() - 1;
    }
}
