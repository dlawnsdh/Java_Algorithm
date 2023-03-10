class Solution {
    public int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String str = "";
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                str += s.charAt(i);
                i++;   
            }
            else {
                String tmp1 = "";
                String tmp2 = "";
                String tmp3 = "";
                if (i + 3 <= s.length())
                    tmp1 = s.substring(i, i + 3);
                if (i + 4 <= s.length())
                    tmp2 = s.substring(i, i + 4);
                if (i + 5 <= s.length())
                    tmp3 = s.substring(i, i + 5);
                
                for (int k = 0; k < arr.length; k++) {
                    if (tmp1.equals(arr[k])) {
                        str += Integer.toString(k);
                        i += 3;
                        break;
                    }
                    if (tmp2.equals(arr[k])) {
                        str += Integer.toString(k);
                        i += 4;
                        break;
                    }
                    if (tmp3.equals(arr[k])) {
                        str += Integer.toString(k);
                        i += 5;
                        break;
                    }
                }
            }
        }
        return Integer.parseInt(str);
    }
}