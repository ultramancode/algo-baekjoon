import java.util.*;
 
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;        
        Arrays.sort(score);
        // 이 문제에선 score.length-1로 하면 기준점이 바뀌니..
        for(int i = score.length; i >= m; i -= m){
            answer += m * score[i - m];
        }
        return answer;
    }
}
