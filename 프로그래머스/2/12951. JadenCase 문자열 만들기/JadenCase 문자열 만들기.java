class Solution {
    public String solution(String s) {
        StringBuilder b = new StringBuilder();
        char[] arr = (" " + s).toLowerCase().toCharArray();
        
        for (int i = 1; i < arr.length; i++) {
            if (Character.isAlphabetic(arr[i]) && arr[i - 1] == ' ')
                arr[i] -= 32;
            b.append(arr[i]);
        }
        
        return b.toString();
    }
}