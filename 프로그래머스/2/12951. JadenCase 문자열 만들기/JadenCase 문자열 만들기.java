class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = (" " + s).toLowerCase();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ' && Character.isAlphabetic(s.charAt(i)))
                sb.append((char) (s.charAt(i) - 32));
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}