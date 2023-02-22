class Solution {
    public String solution(String s) {        
        int size = s.length();
        if (size == 1 || size == 2)
            return s;
        if (size % 2 == 0)
            return s.substring(size / 2 - 1, size / 2 + 1);
        return s.substring(size / 2, size / 2 + 1);
    }
}