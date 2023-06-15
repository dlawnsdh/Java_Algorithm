class Solution {
    public String solution(String new_id) {
        String str = "";
        
        new_id = new_id.toLowerCase();
        
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (String.valueOf(c).matches("[a-z0-9-_.]"))    
                str += c;
        }
        
        str = str.replaceAll("\\.{2,}", ".");
        
        if (str.startsWith(".")) str = str.substring(1);
        if (!str.isEmpty() && str.charAt(str.length() - 1) == '.') 
            str = str.substring(0, str.length() - 1);
        
        if (str.isEmpty()) str = "a";
        
        if (str.length() > 15) str = str.substring(0, 15);
        if (str.charAt(str.length() - 1) == '.') 
            str = str.substring(0, str.length() - 1);
        
        if (str.length() == 1) str = str.repeat(3);
        else if (str.length() == 2) str += str.charAt(1);
        
        return str;
    }
}