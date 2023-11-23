import java.util.*;
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        for(int i = 0; i < n; i++){
            //(long)안해주면 테스트케이스 13,14 실패
            answer[i] = (long)x * (i+1);
        }
        return answer;
    }
}