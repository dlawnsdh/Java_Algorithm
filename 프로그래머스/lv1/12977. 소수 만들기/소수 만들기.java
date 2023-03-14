class Solution {
    public int solution(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++)
            for (int k = i + 1; k < nums.length; k++)
                for (int j = k + 1; j < nums.length; j++) {
                    int sum = nums[i] + nums[k] + nums[j];
                    boolean flag = true;
                    for (int n = 2; n <= Math.sqrt(sum); n++)
                        if (sum % n == 0) {
                            flag = false;
                            break;
                        }
                    if (flag)
                        cnt++;    
                }
        return cnt;
    }
}