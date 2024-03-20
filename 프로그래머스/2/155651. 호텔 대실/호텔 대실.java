import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        LinkedList<LinkedList<String[]>> rooms = new LinkedList<>();
        Arrays.sort(book_time, (t1, t2) -> {
            int[] st1 = {Integer.parseInt(t1[0].substring(0, 2)), Integer.parseInt(t1[0].substring(3))};
            int[] st2 = {Integer.parseInt(t2[0].substring(0, 2)), Integer.parseInt(t2[0].substring(3))};
            if (st1[0] == st2[0])
                return Integer.compare(st1[1], st2[1]);
            return Integer.compare(st1[0], st2[0]);   
        });
        
        rooms.add(new LinkedList<>());
        rooms.getFirst().add(book_time[0]);
        for (int i = 1; i < book_time.length; i++) {
            boolean flag = false;
            for (int k = 0; k < rooms.size(); k++)
                if (compare(rooms.get(k).getLast()[1], book_time[i][0])) {
                    rooms.get(k).add(book_time[i]);
                    flag = true;
                    break;
                }
            if (!flag) {
                rooms.add(new LinkedList<>());
                rooms.getLast().add(book_time[i]);
            }
        }
        return rooms.size();     
    }
    
    public boolean compare(String en, String st) {
        int[] end = {Integer.parseInt(en.substring(0, 2)), Integer.parseInt(en.substring(3))};
        int[] start = {Integer.parseInt(st.substring(0, 2)), Integer.parseInt(st.substring(3))};
        if (end[1] + 10 >= 60) {
            end[0]++;
            end[1] -= 50;
        } else end[1] += 10; 
        
        return end[0] < start[0] || (end[0] == start[0] && end[1] <= start[1]);
    }
}