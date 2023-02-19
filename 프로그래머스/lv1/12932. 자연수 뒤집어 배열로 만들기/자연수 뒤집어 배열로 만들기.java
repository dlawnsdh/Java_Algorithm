class Solution {
    public int[] solution(long n) {
        StringBuffer s = new StringBuffer(Long.toString(n));
        s = s.reverse();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - 48;
        }
        return arr;
    }
}