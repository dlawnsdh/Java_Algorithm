class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        
        char c = s.charAt(0);
        answer += c > 96 && c < 123 ? (char) (c - 32) : c;
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            if (s.charAt(i - 1) == ' ' && c > 96 && c < 123) 
                answer += (char) (c - 32);
            else answer += s.charAt(i);
        }
        return answer;
    }
}