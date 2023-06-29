import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> l = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int n = s.nextInt();
        int k = s.nextInt();
        for (int i = 1; i <= n; i++)
            l.add(i);
        
        int index = k - 1;
        list.add(l.remove(index));
        
        while (l.size() > 0) {
            if (index + k - 1 >= l.size()) {
                index--;
                for (int i = 0; i < k; i++) {
                    index++;
                    if (index == l.size())
                        index = 0;
                }
            }
            else index += k - 1;

            list.add(l.remove(index));
        }

        System.out.print("<");
        for (int i = 0; i < list.size() - 1; i++)
            System.out.print(list.get(i) + ", ");
        System.out.print(list.get(n - 1) +  ">");
    }
}