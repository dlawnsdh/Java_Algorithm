import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] arr = Arrays.stream(tangerine)
            .boxed()
            .collect(Collectors.groupingBy(t -> t, Collectors.counting()))
            .values()
            .stream().sorted(Collections.reverseOrder())
            .mapToInt(Long::intValue)
            .toArray();
        int sum = 0;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum >= k) {
                num = i + 1;   
                break;
            }
        }
        return num;
    }
}