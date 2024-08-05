import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int t = minerals.length % 5 == 0 ? minerals.length / 5 : minerals.length / 5 + 1; 
        t = Math.min(t, picks[0] + picks[1] + picks[2]);
        
        int[][] num = new int[t][3]; // 각 곡괭이의 수(광물을 5개씩 나누어 캘 때)
        int idx = 0;
        int tmp = 0;
        for (int i = 0; i < minerals.length; i++) {
            if (tmp == 5) {
                tmp = 0;
                idx++;
            }
            if (idx == t) break;
            if (minerals[i].equals("diamond")) num[idx][0]++;
            else if (minerals[i].equals("iron")) num[idx][1]++;
            else num[idx][2]++;
            tmp++;
        }
        
        int[][] tired = new int[t][4]; // 각 곡괭이를 가지고 광물을 캐는 피로도와 다이아, 철, 돌 곡괭이로 캐는 피로도의 총합
        for (int i = 0; i < t; i++) {
            tired[i][0] = num[i][0] + num[i][1] + num[i][2];
            tired[i][1] = num[i][0] * 5 + num[i][1] + num[i][2];
            tired[i][2] = num[i][0] * 25 + num[i][1] * 5 + num[i][2];
            tired[i][3] = tired[i][0] + tired[i][1] + tired[i][2];
        }
        Arrays.sort(tired, (a, b) -> b[3] - a[3]); // 피로도의 총합으로 내림차순 정렬
        
        int answer = 0;
        for (int i = 0; i < t; i++) {
            if (picks[0] > 0) {
                answer += tired[i][0];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += tired[i][1];
                picks[1]--;
            } else {
                answer += tired[i][2];
                picks[2]--;
            }
        }
        return answer;
    }
}