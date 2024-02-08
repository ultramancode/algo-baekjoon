import java.util.*;
class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : arr){
            if(c == '('){
                stack.push(c);
            }else if(c== ')') {
                if(!stack.isEmpty() &&stack.peek() == '('){
                    stack.pop();
                } else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
}
}