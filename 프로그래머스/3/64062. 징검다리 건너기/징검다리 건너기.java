import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        LinkedList<int[]> q = new LinkedList<>();
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stones.length; i++) {
            while (!q.isEmpty() && q.peekLast()[0] < stones[i]) // 큐가 안비어있고 큐의 마지막 원소보다 현재 값이 더 크면 뒤에서 부터 빼줌 
                q.pollLast();                                   // 이렇게 하면 큐의 가장 앞 원소가 해당 슬라이딩 윈도우의 max 값
            q.add(new int[] {stones[i], i}); // 값과 해당 인덱스를 짝으로 큐에 넣어줌
            
            if (i - k == q.peek()[1]) // 현재 인덱스 - k 와 큐의 맨앞(max)의 인덱스가 같다면 (이전 max 값이 슬라이딩 윈도우에서 제외됨) 큐의 앞에서 빼줌
                q.poll();
            if (k - i <= 1) // 인덱스가 k 보다 작다면 맨 처음 k 개 만큼의 슬라이딩 윈도우를 채우지 못했으므로 min 값을 갱신하지 않음
                min = Math.min(min, q.peek()[0]);
        }
        return min;
    }
}