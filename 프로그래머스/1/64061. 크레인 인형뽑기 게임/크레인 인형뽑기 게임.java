import java.util.*;

class Solution {

    public int solution(int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                //moves는 첫칸을 1로 잡고있으니 -1해서 인덱스랑 매칭
                int temp = board[j][moves[i]-1];
                if (temp != 0) {
                    //인형 뽑았으니 0
                    board[j][moves[i]-1] = 0;
                    if (!stack.isEmpty()) {
                        int peek = stack.peek();
                        if (peek == temp) {
                            stack.pop();
                            count += 2;
                        } else {
                            stack.push(temp);
                        }
                    } else {
                        stack.push(temp);
                    }   
                    //인형 뽑은 턴에는 종료해야지 계속 뽑으면 안맞음
                    break; 
                    }
                 }
              }
        return count;
        }
    }
