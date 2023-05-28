import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
            list.add(s.nextLine());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] arr1 = o1.split(" ");
                String[] arr2 = o2.split(" ");
                if (arr1[0].equals(arr2[0]))
                    return 0;
                return Integer.compare(Integer.parseInt(arr1[0]), Integer.parseInt(arr2[0]));
            }
        });

        for (String str : list)
            System.out.println(str);
    }
}