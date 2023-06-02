import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Stage> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            double a = 0;
            double b = 0;
            for (int k = 0; k < stages.length; k++) {
                if (stages[k] > i) b++;
                if (stages[k] == i) {
                    a++;
                    b++;
                }
            }
            list.add(new Stage(i, a / b));
        }
        Collections.sort(list);

        return list.stream().mapToInt(s -> s.stage).toArray();
    }
    
    public class Stage implements Comparable<Stage> {
        int stage;
        double success;

        public Stage(int stage, double success) {
            this.stage = stage;
            this.success = success;
        }

        @Override
        public int compareTo(Stage s1) {
            if (s1.success < success)
                return -1;
            else if (s1.success > success)
                return 1;
            else
                return Integer.compare(stage, s1.stage);
        }
    }
}