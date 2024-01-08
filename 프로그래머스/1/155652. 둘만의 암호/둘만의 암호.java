class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] arr = s.toCharArray();
        for(int i =0; i<arr.length; i++){
            char c = arr[i];
           for(int j =0; j<index; j++){
            c += 1;
            if(c>'z'){
                c -= 26;
            }
            if(skip.contains(String.valueOf(c))){
                j--;
            }
        }  
            answer +=c;
        }
       
        return answer;
    }
}