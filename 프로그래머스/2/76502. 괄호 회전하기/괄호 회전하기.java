import java.util.*;

class Solution {
    
    public int solution(String s) {

        int answer = 0;
        for(int i = 0; i<s.length(); i++){
            String rotated = rotate(s, i);
            if(isValid(rotated)){
                answer++;
            }
        }
        return answer;
    }
    
    
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c =='[' || c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(c==')' && top != '(') return false;
                if(c==']' && top != '[') return false;
                if(c=='}' && top != '{') return false;
            }
        }
        return stack.isEmpty();
    }
    
    public String rotate(String s, int x){
        return s.substring(x) + s.substring(0,x);
    }
}