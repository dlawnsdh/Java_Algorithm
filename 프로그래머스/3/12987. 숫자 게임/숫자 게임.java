import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int idxA = 0;
        int idxB = 0;
        int cnt = 0;
        while (idxA < A.length && idxB < B.length) {
            if (A[idxA] < B[idxB]) {
                idxA++;
                idxB++;
                cnt++;
            } else idxB++;
        }
        return cnt;
    }
}