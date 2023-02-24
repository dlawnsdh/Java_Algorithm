class Solution {
    public String solution(String s, int n) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (c > 64 && c < 91) {
                    if (c + n > 90)
                        c = (char) ((c + n - 90 - 1) + 65);
                    else c += n;
                }
                else {
                    if (c + n > 122)
                        c = (char) ((c + n - 122 - 1) + 97);
                    else c += n;
                }
                str += c;
            }
            else str += c;
        }
        return str;
    }
}