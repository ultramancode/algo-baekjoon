class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        String[] arr = s.toLowerCase().split(" ");

        for (int i = 0; i < arr.length; i++) {
            //아..진짜
            if (arr[i].length() ==0) {
                result.append(" ");
                }
            else {
                result.append(arr[i].substring(0,1).toUpperCase());
                result.append(arr[i].substring(1,arr[i].length()));
                result.append(" ");
            }
        }
        
        String answer = result.toString();
        
        if(!s.endsWith(" ")){
            return answer.substring(0,answer.length()-1);
        }
        
        return answer; 
        
        }
}