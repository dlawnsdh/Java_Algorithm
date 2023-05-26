import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();

        double sum = 100;
        Arrays.sort(arr);
        double max = arr[arr.length - 1];
        arr[arr.length - 1] = 100;
        for (int i = 0; i < arr.length - 1; i++)
            sum += arr[i] / max * 100;

        System.out.println(sum / n);
    }
}