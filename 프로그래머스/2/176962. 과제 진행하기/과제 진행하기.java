import java.util.*;

class Solution {
    class Homework implements Comparable<Homework> {
        String name;
        int start;
        int time;
        
        Homework(String n, int s, int t) {
            this.name = n;
            this.start = s;
            this.time = t;
        }
        
        void changeStart(int t) {
            start = t;
        }
        
        void discountTime(int t) {
            time -= t;
        }
        
        String tostring() {
            return String.format("%d:%d", start / 60, start % 60);
        }   
        
        @Override
        public int compareTo(Homework o) {
            return this.start - o.start;
        }
    }
    
    int convertTime(String time) {
        return 60 * Integer.parseInt(time.substring(0, 2)) + Integer.parseInt(time.substring(3));
    }
    
    public String[] solution(String[][] plans) {
        PriorityQueue<Homework> hw = new PriorityQueue<>();
        for (String[] p : plans)
            hw.add(new Homework(p[0], convertTime(p[1]), Integer.parseInt(p[2])));
        
        List<String> complete = new ArrayList<>();
        Homework prev = hw.poll();
        Stack<Homework> next = new Stack<>();
        while (!hw.isEmpty()) {
            if (prev.start + prev.time < hw.peek().start) {
                complete.add(prev.name);
                if (!next.isEmpty()) {
                    next.peek().changeStart(prev.start + prev.time);
                    prev = next.pop();    
                } else prev = hw.poll();
            } else if (prev.start + prev.time == hw.peek().start) {
                complete.add(prev.name);
                prev = hw.poll();
            } else {
                prev.discountTime(hw.peek().start - prev.start);
                next.push(prev);
                System.out.println(prev.name + " " + prev.time);
                prev = hw.poll();
            }
        }
        complete.add(prev.name); // 맨 마지막 과제는 새로 진행할 과제가 없으므로 미뤄둔 과제를 하기전에 끝냄
        while (!next.isEmpty())
            complete.add(next.pop().name);
        
        return complete.stream().toArray(String[]::new);
    }
}