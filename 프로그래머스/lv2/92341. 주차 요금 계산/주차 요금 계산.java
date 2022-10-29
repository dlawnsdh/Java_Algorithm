import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] fees, String[] records) {        
        ArrayList<Fee> list = new ArrayList<>();
        for (int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");
            String[] time = arr[0].split(":");
            list.add(new Fee(
                    Integer.parseInt(time[0]),
                    Integer.parseInt(time[1]),
                    Integer.parseInt(arr[1]),
                    arr[2]));
        }
        list.sort(Comparator.comparing(Fee::getNumber));

        Set<Integer> set = new HashSet<>();
        for(Fee fee : list)
            if (!set.contains(fee.number))
                set.add(fee.number);
        List<Integer> arr = set.stream().collect(Collectors.toList());
        Collections.sort(arr);

        int[] answer = new int[set.size()];
        int index = 0; //int k = 0;


        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Fee> innerList = new ArrayList<>();
            for (Fee fee : list)  {
                if (arr.get(i) == fee.number)
                    innerList.add(fee);
            }

            for (int k = 0; k < innerList.size(); k++) {
                if (k == innerList.size() - 1) {
                    if (innerList.get(k).record.equals("IN")) {
                        int time = (23 - innerList.get(k).hour) * 60 + 59 - innerList.get(k).minute;
                        answer[i] += time;
                    }
                }
                else {
                    if (innerList.get(k).record.equals("IN") && innerList.get(k + 1).record.equals("OUT")) {
                        int time = (innerList.get(k + 1).hour - innerList.get(k).hour) * 60 +
                                innerList.get(k + 1).minute - innerList.get(k).minute;
                        answer[i] += time;
                    }
                }
            }
        }
        
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] <= fees[0] )
                answer[i] = fees[1];
            else {
                double tmp = Math.ceil((answer[i] - fees[0]) / (double) fees[2]);
                answer[i] = fees[1] + (int) tmp * fees[3];
            }
        }
        
        return answer;
    }
    
    public class Fee {
        public int hour;
        public int minute;
        public int number;
        public String record;
        
        public Fee(int hour, int minute, int number, String record) {
            this.hour = hour;
            this.minute = minute;
            this.number = number;
            this.record = record;
        }
        
        public int getNumber() {
            return number;
        }
    }
}