import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] time = Arrays.stream(timetable)
                .mapToInt(s -> Integer.parseInt(s.substring(0, 2)) * 60 + 
                        Integer.parseInt(s.substring(3)))
                .sorted()
                .toArray();
        
        int[] bus = new int[n];
        bus[0] = 540;
        for (int i = 1; i < n; i++)
            bus[i] += bus[i - 1] + t;
        
        LinkedList<LinkedList<Integer>> num = new LinkedList<>();
        for (int i = 0; i < n; i++) 
            num.add(new LinkedList<>());
        int idx = 0;
        int tmp = 0;
        for (int i = 0; i < time.length; i++) {
            while (idx < n && time[i] > bus[idx]) {
                idx++;
                tmp = 0;
            }
            if (tmp == m) {
                tmp = 0;
                idx++;
            }
            if (idx == n) break;
            if (time[i] <= bus[idx]) {
                num.get(idx).add(time[i]);
                tmp++;    
            }
        }
        
        int lastPerson = num.getLast().isEmpty() ? 0 : num.getLast().getLast();
        int len = num.getLast().isEmpty() ? 0 : num.getLast().size();
        String hour, minute;
        if (len < m) {
            hour = String.valueOf(bus[n - 1] / 60);
            minute = String.valueOf(bus[n - 1] % 60);
        } else {
            hour = String.valueOf((lastPerson - 1) / 60);
            minute = String.valueOf((lastPerson - 1) % 60);
        }
        hour = hour.length() == 1 ? "0" + hour : hour;
        minute = minute.length() == 1 ? "0" + minute : minute;
        return hour + ":" + minute; 
    }
}