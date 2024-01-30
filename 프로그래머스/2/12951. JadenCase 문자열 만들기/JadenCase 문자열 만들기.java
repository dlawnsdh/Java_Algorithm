class Solution {
    public String solution(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        if (Character.isLowerCase(arr[0])) arr[0] -= 32;
        for (int i = 1; i < arr.length; i++) 
            if (arr[i - 1] == ' ' && Character.isLowerCase(arr[i])) 
                arr[i] -= 32;
        return String.valueOf(arr);
    }
}