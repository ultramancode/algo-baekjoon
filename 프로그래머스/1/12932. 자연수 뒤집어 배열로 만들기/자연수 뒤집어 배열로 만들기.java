import java.util.*;
class Solution {
    public int[] solution(long n) {
        String convert = String.valueOf(n);

        int[] answer = new int[convert.length()];
        
        char[] a = convert.toCharArray();
        for(int i = 0; i<a.length; i++){
            answer[i] = a[i] -'0';
        }

        int left = 0;
        int right = answer.length-1;
        while(left<right){
            int tmp = answer[left];
            answer[left] = answer[right];
            answer[right] = tmp;
            left++;
            right--;
        }
        return answer;

    }
}