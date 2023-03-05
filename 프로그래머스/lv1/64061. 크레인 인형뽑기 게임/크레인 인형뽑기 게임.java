import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < moves.length; i++) 
            for (int k = 0; k < board.length; k++) 
                if (board[k][moves[i] - 1] != 0) {
                    int tmp = board[k][moves[i] - 1];
                    board[k][moves[i] - 1] = 0;
                    if (!stack.empty() && stack.peek() == tmp) {
                        stack.pop();
                        cnt += 2;
                    }
                    else stack.push(tmp);
                    break;
                }
        return cnt;
    }
}