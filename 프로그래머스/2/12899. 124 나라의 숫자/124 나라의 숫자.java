class Solution {
    public String solution(int n) {
        StringBuilder b = new StringBuilder();
        String[] num = {"1", "2", "4"};
        int numOfDigit = 0;
        int sum = 0;
        while (sum < n) {
            numOfDigit++;
            sum += Math.pow(3, numOfDigit);
        }
        
        n -= sum - Math.pow(3, numOfDigit);
        int idx = numOfDigit - 1;
        while (idx > 0 && n > 0) {
            if (n % (int) Math.pow(3, idx) == 0)
                b.append(num[(n / (int) Math.pow(3, idx) - 1) % 3]);
            else b.append(num[(n / (int) Math.pow(3, idx)) % 3]);
            n %= Math.pow(3, idx);
            idx--;
        }
        
        if (n == 0)
            for (int i = b.length(); i < numOfDigit; i++)
                b.append(4);
        else b.append(num[n - 1]);
        return b.toString();
    }
}