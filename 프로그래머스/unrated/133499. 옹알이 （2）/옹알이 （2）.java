class Solution {
    public int solution(String[] babbling) {
        String[] str = {"aya", "ye", "woo", "ma"};
        int cnt = 0;
        
        for (int i = 0; i < babbling.length; i++) {
            int[] arr = {0, 0, 0, 0};
            String s = "";
            String tmp = "";
            int index = 0;
            
            Outer : for (int j = 0; j < babbling[i].length(); j++) {
                s += babbling[i].charAt(j);
                for (int k = 0; k < str.length; k++) {
                    if (str[k].equals(s)) {
                        arr[k]++;
                        
                        if (tmp.equals(str[k]) && arr[k] > 1) {
                            index -= str[k].length() * 2;
                            break Outer;
                        }
                        
                        tmp = s;
                        index += str[k].length();
                        s = "";
                    }
                }
            }
            if (index == babbling[i].length())
                cnt++;
        }
        
        return cnt;
    }
}