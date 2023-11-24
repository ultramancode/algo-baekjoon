class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int length = phone_number.length();
        
        String tmp = "*".repeat(length-4);
        phone_number= phone_number.substring(length-4);
            
            answer = tmp+phone_number; 
        
        
        return answer;
    }
}