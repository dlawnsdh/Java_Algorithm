import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];
        
        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 2 == 0)
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            if (i % 3 == 0) // else if 로 검사하면 6같은 2와 3모두 약수로 가진 수에서 2만 검사하고 3은 안하기 때문에 둘다 if 문으로 검사하게끔 한다
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
        }
        System.out.print(arr[n]);
    }
}
