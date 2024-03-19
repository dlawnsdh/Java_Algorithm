import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] gems) {        
        int num = Arrays.stream(gems).collect(Collectors.toSet()).size();
        Map<String, Integer> m = new HashMap<>();
        
        // 초깃값 세팅
        int[] result = new int[2];
        int st = 0;
        int en = -1;
        // 왼쪽부터 탐색하면서 가장 첫 번째로 탐색되는 구간 찾기 -> 
        // en 증가시키면서 총 보석 종류와 맵의 키셋의 사이즈가 같아질 때까지 넣음
        while (m.keySet().size() < num)
            m.compute(gems[++en], (k, v) -> v == null ? 1 : v + 1);
        // 왼쪽부터 st 증가시키면서 해당 보석이 2개 이상이면 줄이면서 넘어감
        while (m.get(gems[st]) > 1)
            m.compute(gems[st++], (k, v) -> v - 1);
        
        // 초깃값으로 result 배열과 해당 구간의 길이 설정
        result[0] = st + 1;
        result[1] = en + 1;
        int min = en - st + 1;
        while (en + 1 < gems.length) {
            // 슬라이딩 윈도우 방식으로 en 을 하나 증가시켜서 맵에 넣음
            m.compute(gems[++en], (k, v) -> v + 1);
            // st 를 증가시키면서 해당 보석이 2개 이상이고 맵이 보석의 모든 종류를 포함하면 줄이면서 넘어감 -> 여기서 구간의 길이가 감소할 수 있음
            while (m.get(gems[st]) > 1 && m.keySet().size() == num)
                m.compute(gems[st++], (k, v) -> v - 1);
            if (m.keySet().size() == num && min > en - st + 1) { // 구간의 길이가 감소 했다면 (st 와 en 간의 차이가 줄었다면) 최솟값 갱신
                min = en - st + 1;
                result[0] = st + 1;
                result[1] = en + 1;
            }
        }
        return result;
    }
}