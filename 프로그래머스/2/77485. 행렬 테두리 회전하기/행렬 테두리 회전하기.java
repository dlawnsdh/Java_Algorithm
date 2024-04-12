import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++)
            for (int k = 0; k < columns; k++)
                arr[i][k] = num++;
        
        LinkedList<Integer> l = new LinkedList<>();
        int[] result = new int[queries.length];
        int idx = 0;
        for (int[] q : queries) {
            // 행렬 테두리 리스트에 넣기
            for (int k = q[1] - 1; k < q[3]; k++)
                l.add(arr[q[0] - 1][k]);
            for (int k = q[0]; k < q[2] - 1; k++)
                l.add(arr[k][q[3] - 1]);
            for (int k = q[3] - 1; k >= q[1] - 1; k--)
                l.add(arr[q[2] - 1][k]);
            for (int k = q[2] - 2; k > q[0] - 1; k--)
                l.add(arr[k][q[1] - 1]);
            
            // 한 칸씩 회전하고 최솟값 찾기
            for (int i = 1; i < l.size(); i++)
                l.add(l.poll());
            result[idx++] = l.stream().min(Integer::compare).orElse(0);
            
            // 원래 배열에 적용
            for (int k = q[1] - 1; k < q[3]; k++)
                arr[q[0] - 1][k] = l.poll();
            for (int k = q[0]; k < q[2] - 1; k++)
                arr[k][q[3] - 1] = l.poll();
            for (int k = q[3] - 1; k >= q[1] - 1; k--)
                arr[q[2] - 1][k] = l.poll();
            for (int k = q[2] - 2; k > q[0] - 1; k--)
                arr[k][q[1] - 1] = l.poll();
        }
        return result;
    }
}