class Solution {
    public boolean solution(int x) {
        String s = Integer.toString(x);
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum += s.charAt(i) - 48;
        return x % sum == 0;
    }
}