class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] result = new int[2];
        int[] arr = new int[46];
        int correct = 0;
        
        for (int i = 0; i < lottos.length; i++)
            arr[lottos[i]]++;
        for (int i = 0; i < win_nums.length; i++)
            arr[win_nums[i]]++;
        for (int i = 1; i < arr.length; i++) 
            if (arr[i] == 2) 
                correct++;
        
        if (6 > correct + arr[0] && correct + arr[0] > 1) 
            result[0] = 7 - (correct + arr[0]);
        else if (correct + arr[0] < 2)
            result[0] = 6;
        else
            result[0] = 1;
        if (correct == 0 || correct == 1)
            result[1] = 6;
        else
            result[1] = 7 - correct;
        return result;
    }
}