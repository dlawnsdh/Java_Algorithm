import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int k = sc.nextInt();  
        int[][] arr = new int[6][2];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int y = sc.nextInt();
            arr[y - 1][s]++;
        }
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) 
            sum += (arr[i][0] / k + arr[i][0] % k + arr[i][1] / k + arr[i][1] % k);
        System.out.print(sum);
    }
}