import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int n = 0;
        LinkedList<XY> list = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++)
            list.add(new XY(priorities[i], i));
        
        while (!list.isEmpty()) {
            int cnt = 0;
            for (int i = 1; i < list.size(); i++) 
                if (list.peek().x < list.get(i).x) {
                    list.addLast(list.poll()); 
                    cnt = 1;
                    break;
                }
            if (cnt == 0) {
                if (list.peek().y == location) {
                    answer = n + 1;
                    break;
                }
                else {
                    list.poll();
                    n++;
                }
            }
        }
        return answer;
    }
    
    class XY {
        public int x;
        public int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}