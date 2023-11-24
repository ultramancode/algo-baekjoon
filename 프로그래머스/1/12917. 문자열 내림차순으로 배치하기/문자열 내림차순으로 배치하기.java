import java.util.*;
class Solution {
    public String solution(String s) {

        
        ArrayList<Character> cArr = new ArrayList<>();
        char[] arr = s.toCharArray();
        
        for(char c : arr ){
            cArr.add(c);
        }
        
        Collections.sort(cArr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(char c : cArr){
            sb.append(c);
        }
        return sb.toString();
    }
}