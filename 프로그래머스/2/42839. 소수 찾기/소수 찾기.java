import java.util.*;

class Solution {
    public Set<Integer> s = new HashSet<>();
    
    public void permutation(int[] arr, int[] result, boolean[] visited, int k, int r) {
        if (k == r) {
            StringBuilder b = new StringBuilder();
            for (int i : result)
                b.append(i);
            if (isPrime(Integer.parseInt(b.toString()))) 
                s.add(Integer.parseInt(b.toString()));
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[k] = arr[i];
                permutation(arr, result, visited, k + 1, r);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
    
    public int solution(String numbers) {
        int[] arr = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++)
            arr[i] = numbers.charAt(i) - 48;
        for (int i = 1; i <= arr.length; i++)
            permutation(arr, new int[i], new boolean[arr.length], 0, i);
        return s.size();
    }
}