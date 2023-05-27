import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(s.nextLine());

        List<String> list = new ArrayList<>(set);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return Integer.compare(o1.length(), o2.length());
            }
        });

        for (String str : list)
            System.out.println(str);
    }
}