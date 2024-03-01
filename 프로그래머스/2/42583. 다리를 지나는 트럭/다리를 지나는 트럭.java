import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        LinkedList<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++)
            bridge.add(0);
        
        int time = 0;
        int sum = 0;
        for (int w : truck_weights) {
            sum -= bridge.poll();
            time++;
            while (sum + w > weight) {
                sum -= bridge.poll();
                bridge.add(0); // 차간 거리를 0으로 채워줌 -> 다리를 빠져나가는 시간 만큼 0이 추가됨
                time++;        // ex) 7 0 0 4 라면 7은 빠져나가는데 1초 4는 3초가 걸림 
            }
            bridge.add(w);
            sum += w;
        }
        while (!bridge.isEmpty()) { // for 문이 종료되는 시점이 마지막 차량이 다리에 들어서는 시점이므로
            bridge.poll();          // 마지막 차량이 다리를 빠져나가는 시간 계산
            time++;
        }
        return time;
    }
}