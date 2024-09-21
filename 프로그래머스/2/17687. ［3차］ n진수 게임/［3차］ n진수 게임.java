class Solution {
    public String solution(int n, int t, int m, int p) {
        char[] arr = new char[m * t];
        int idx = 0;
        int num = 0;
        while (idx < arr.length) {
            StringBuilder b = new StringBuilder(); 
            int k = num++;
            while (k >= n) {
                if (k % n >= 10)
                    b.append((char) (k % n + 55));
                else b.append(k % n);
                k /= n;
            }
            if (k >= 10) b.append((char) (k + 55));
            else b.append(k);
            b.reverse();
            
            for (int i = 0; i < b.length(); i++) {
                arr[idx++] = b.charAt(i);
                if (idx >= arr.length) 
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = p - 1; i < arr.length; i += m)
            sb.append(arr[i]);
        return sb.toString();
    }
}