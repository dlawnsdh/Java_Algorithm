import java.util.*;

class Solution {
    int convert(String t) {
        return 60 * Integer.parseInt(t.substring(0, 2)) + Integer.parseInt(t.substring(3)); 
    }
    
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> room = new PriorityQueue<>();
        Arrays.sort(book_time, (a, b) -> convert(a[0]) - convert(b[0]));
        
        for (String[] book : book_time) {
            if (!room.isEmpty() && room.peek() <= convert(book[0]))
                room.poll();    
            room.add(convert(book[1]) + 10);
        }
        return room.size();
    }
}