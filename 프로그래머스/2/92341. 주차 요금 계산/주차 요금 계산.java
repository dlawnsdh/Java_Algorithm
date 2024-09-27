import java.util.*;
import java.util.stream.*;

class Solution {
    class Info implements Comparable<Info>{
        String carNum;
        List<Integer> record = new ArrayList<>();
        
        Info(String n) { 
            this.carNum = n; 
        }
        
        int getTotalFee(int[] fees) {
            if (record.size() % 2 != 0)
                record.add(convertTime("23:59"));
            
            int totalTime = 0;
            for (int i = 1; i < record.size(); i += 2)
                totalTime += record.get(i) - record.get(i - 1);
                
            if (totalTime <= fees[0])
                return fees[1];
            return fees[1] + (int) Math.ceil((double) (totalTime - fees[0]) / fees[2]) * fees[3];
        }
        
        @Override
        public int compareTo(Info o) {
            return this.carNum.compareTo(o.carNum);
        }
    }
    
    int convertTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));
        return hour * 60 + minute;
    }
    
    Map<String, Info> fee = new HashMap<>();
    
    public int[] solution(int[] fees, String[] records) {        
        for (String r : records) {
            String carNum = r.substring(6, 10);
            fee.computeIfAbsent(carNum, k -> new Info(carNum))
                .record
                .add(convertTime(r.substring(0, 5)));
        }
        
        return fee.values().stream()
            .sorted()
            .mapToInt(info -> info.getTotalFee(fees))
            .toArray();
    }
}