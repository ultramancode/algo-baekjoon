import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String str = String.valueOf(n);
        char[] charArr = str.toCharArray();
        for(int i = 0; i<charArr.length; i++){
        
            answer += charArr[i] -'0';
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}