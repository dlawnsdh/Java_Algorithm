import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<String[]> l = new ArrayList<>();
        for (String name : files) {
            String[] arr = new String[3];
            StringBuilder b = new StringBuilder();
            int idx = 0;
            for (; idx < name.length(); idx++) {
                if (!Character.isDigit(name.charAt(idx)))
                    b.append(name.charAt(idx));
                else break;
            }
            arr[0] = b.toString();
            b = new StringBuilder();
            for (; idx < name.length(); idx++) {
                if (Character.isDigit(name.charAt(idx)) && b.length() < 5) 
                    b.append(name.charAt(idx));
                else break;
            }
            arr[1] = b.toString();
            arr[2] = name.substring(idx);
            l.add(arr);
        }
        
        return l.stream()
            .sorted((arr1, arr2) -> {
                if (arr1[0].equalsIgnoreCase(arr2[0]))
                    return Integer.compare(Integer.parseInt(arr1[1]), Integer.parseInt(arr2[1]));
                return arr1[0].compareToIgnoreCase(arr2[0]);})
            .map(arr -> arr[0] + arr[1] + arr[2])
            .toArray(String[]::new);
    }
}