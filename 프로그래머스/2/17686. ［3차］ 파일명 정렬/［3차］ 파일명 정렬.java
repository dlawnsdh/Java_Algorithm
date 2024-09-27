import java.util.*;

class Solution {
    class FileInfo implements Comparable<FileInfo> {
        String head;
        String number;
        String tail;
        
        FileInfo(String h, String n, String t) {
            this.head = h;
            this.number = n;
            this.tail = t;
        }
        
        String getFullFileName() {
            return head + number + tail;
        }
        
        @Override
        public int compareTo(FileInfo o) {
            if (this.head.compareToIgnoreCase(o.head) == 0)
                return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            return this.head.compareToIgnoreCase(o.head);
        }
    }
    
    public String[] solution(String[] files) {
        List<FileInfo> info = new ArrayList<>();
        
        for (String file : files) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            
            int idx = 0;
            boolean isHead = true;
            while (idx < file.length()) {
                if (!Character.isDigit(file.charAt(idx)) && isHead)
                    head.append(file.charAt(idx++));
                else if (Character.isDigit(file.charAt(idx))) {
                    number.append(file.charAt(idx++));
                    isHead = false;
                } else break;
            }   
            info.add(new FileInfo(head.toString(), number.toString(), file.substring(idx)));
        }
        
        return info.stream()
            .sorted()
            .map(i -> i.getFullFileName())
            .toArray(String[]::new);
    }
}