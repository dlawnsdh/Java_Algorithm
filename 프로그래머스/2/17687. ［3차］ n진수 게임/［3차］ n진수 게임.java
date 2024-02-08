class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder b = new StringBuilder();
        int k = 0;
        while (b.length() < m * (t - 1) + p) {
            int num = k++;
            StringBuffer bf = new StringBuffer();
            while (num >= n) {
                if (num % n >= 10)
                    bf.append((char) (num % n + 55));
                else bf.append(num % n); 
                num /= n;
            }
            if (n > num && num >= 10) bf.append((char) (num + 55)).reverse(); 
            else bf.append(num).reverse();
            b.append(bf);
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = p - 1; i < b.length(); i += m)
            result.append(b.charAt(i));
        return result.substring(0, t);
    }
}