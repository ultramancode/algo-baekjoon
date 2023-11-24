class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        if(s.length() == 4 || s.length()==6){
            answer = true;
            char[] arr = s.toCharArray();
            for(char c : arr){
                if(!Character.isDigit(c)){
                    answer = false;
                }
            }
        }
        
        
        return answer;
    }
}