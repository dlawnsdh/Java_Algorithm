import java.util.*;
import java.util.stream.Collectors.*;

class Solution {
    public int solution(int[] nums) {
        int[] arr = Arrays.stream(nums).distinct().toArray();
        return arr.length < nums.length / 2 ? arr.length : nums.length / 2;
    }
}