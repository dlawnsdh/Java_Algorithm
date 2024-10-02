import java.util.*;

class Solution {
    Set<Integer> prime = new HashSet<>();
    
    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) 
                return false;
        return true;
    }
    
    void dfs(char[] num, boolean[] visited, char[] arr, int d, int r) {
        if (d == r) {
            int i = Integer.parseInt(String.valueOf(arr));
            if (isPrime(i))
                prime.add(i);
        } else {
            for (int i = 0; i < num.length; i++)
                if (!visited[i]) {
                    visited[i] = true;
                    arr[d] = num[i];
                    dfs(num, visited, arr, d + 1, r);
                    visited[i] = false;
                }
        }
    }
    
    public int solution(String numbers) {
        for (int i = 1; i <= numbers.length(); i++)
            dfs(numbers.toCharArray(), new boolean[numbers.length()], new char[i], 0, i);
        return prime.size();
    }
}