class Solution {
    public long[] solution(long[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) numbers[i] += 1;
            else {
                String s = "0" + Long.toBinaryString(numbers[i]);
                int len = s.length() - s.lastIndexOf('0') - 2;
                numbers[i] += (long) Math.pow(2, len);
            }
        }
        return numbers;
    }
}