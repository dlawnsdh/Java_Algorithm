import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<BigInteger> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.stream(br.readLine().split("[a-z]+"))
                .filter(s -> !s.isEmpty())
                .forEach(s -> l.add(new BigInteger(s)));
        }
        l.stream().sorted().forEach(System.out::println);
    }
}