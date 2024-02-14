class Solution {
    public int solution(String word) {
        char[] arr = {'A', 'E', 'I', 'O', 'U'};
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < 5; a++) {
            sb.append(arr[a]);
            if (sb.toString().equals(word)) return cnt;
            else cnt++;
            for (int b = 0; b < 5; b++) {
                sb.append(arr[b]);
                if (sb.toString().equals(word)) return cnt;
                else cnt++;
                for (int c = 0; c < 5; c++) {
                    sb.append(arr[c]);
                    if (sb.toString().equals(word)) return cnt;
                    else cnt++;
                    for (int d = 0; d < 5; d++) {
                        sb.append(arr[d]);
                        if (sb.toString().equals(word)) return cnt;
                        else cnt++;
                        for (int e = 0; e < 5; e++) {
                            sb.append(arr[e]);
                            if (sb.toString().equals(word)) return cnt;
                            else cnt++;
                            sb.deleteCharAt(4);
                        }
                        sb.delete(3, 4);
                    }
                    sb.delete(2, 4);
                }
                sb.delete(1, 4);
            }
            sb.delete(0, 4);
        }
        return cnt;
    }
}