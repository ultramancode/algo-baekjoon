import java.util.*;
class Solution {
    public long solution(long n) {
        String answer ="";
        
        String nStr = String.valueOf(n);
        char[] nArr = nStr.toCharArray();
        Arrays.sort(nArr);
        for(int i = 0; i<nArr.length; i++){
            answer+=nArr[i];
        }
        // StringBuilder sb = new StringBuilder(new String(nArr));
        StringBuilder sb = new StringBuilder(answer);
        answer = sb.reverse().toString();
        return Long.parseLong(answer);
    }
}