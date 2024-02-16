import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {        
        Map<String, ArrayList<Fee>> m = new HashMap<>();
        for (String s : records) {
            String[] arr = s.split(" ");
            Fee fee = new Fee(
                Integer.parseInt(arr[1]),
                Integer.parseInt(arr[0].substring(0, 2)),
                Integer.parseInt(arr[0].substring(3)),
                arr[2]
            );
            ArrayList<Fee> l = m.getOrDefault(arr[1], new ArrayList<>());
            l.add(fee);
            m.put(arr[1], l);
        }
        
        return m.values().stream()
            .sorted((l1, l2) -> Integer.compare(l1.get(0).number, l2.get(0).number))
            .map(l -> {
                int sum = 0;
                if (l.size() == 1) sum = (23 - l.get(0).hour) * 60 + (59 - l.get(0).minute);
                else if (l.size() % 2 == 0) {
                    for (int i = 0; i < l.size() - 1; i += 2) {
                        Fee fee1 = l.get(i);
                        Fee fee2 = l.get(i + 1);
                        sum += (fee2.hour - fee1.hour) * 60 + (fee2.minute - fee1.minute);
                    }    
                } else {
                    for (int i = 0; i < l.size() - 2; i += 2) {
                        Fee fee1 = l.get(i);
                        Fee fee2 = l.get(i + 1);
                        sum += (fee2.hour - fee1.hour) * 60 + (fee2.minute - fee1.minute);
                    }
                    sum += (23 - l.get(l.size() - 1).hour) * 60 + (59 - l.get(l.size() - 1).minute);
                }
                return sum <= fees[0] ? fees[1] : fees[1] + (int) Math.ceil((double) (sum - fees[0]) / (double) fees[2]) * fees[3];
            }).mapToInt(Integer::intValue).toArray();
    }
    
    class Fee {
        int number;
        int hour;
        int minute;
        String state;
        
        public Fee (int n, int h, int m, String s) {
            number = n;
            hour = h;
            minute = m;
            state = s;
        }
    }
}