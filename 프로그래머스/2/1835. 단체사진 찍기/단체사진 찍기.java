class Solution {
    char[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    int count = 0;
    
    void dfs(char[] result, boolean[] visited, int d, String[] data) {
        if (d == 8) {
            if (check(result, data))
                count++;
            return;
        }
        
        for (int i = 0; i < 8; i++)
            if (!visited[i]) {
                visited[i] = true;
                result[d] = arr[i];
                dfs(result, visited, d + 1, data);
                visited[i] = false;
            }

    }
    
    boolean check(char[] arr, String[] data) {
        String str = String.valueOf(arr);
        for (String s : data) {
            int k = Math.abs(str.indexOf(s.charAt(0)) - str.indexOf(s.charAt(2))) - 1;
            int h = s.charAt(4) - 48;
            if (s.charAt(3) == '=' && k != h)
                return false;
            else if (s.charAt(3) == '>' && k <= h) 
                return false;
            else if (s.charAt(3) == '<' && k >= h) 
                return false;
        }
        return true;
    }
    
    public int solution(int n, String[] data) {
        dfs(new char[8], new boolean[8], 0, data);
        return count;
    }
}