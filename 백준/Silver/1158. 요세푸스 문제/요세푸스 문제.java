import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> l = new LinkedList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) l.add(i);
        
        Iterator<Integer> it = l.iterator();
        List<Integer> list = new ArrayList<>();
        while (l.size() > 1) {
            int cnt = k;
            int tmp = 0;
            while (cnt > 0) {
                if (!it.hasNext()) it = l.iterator();
                int t = it.next();
                cnt--;
                if (cnt == 0) tmp = t;
            }
            list.add(tmp);
            it.remove();
        }
        System.out.print("<");
        for (int i : list) System.out.print(i + ", ");
        System.out.print(l.peek() + ">");
    }
}