class Solution {
      public String solution(String s) {
        char[] arr = s.toCharArray();

        if(s.length() % 2 == 0){ 
            char[] answer = new char[2];
            answer[0] = arr[s.length() / 2 - 1];
            answer[1] = arr[s.length() / 2];
            return new String(answer);
        } else { 
            char[] answer = new char[1];
            answer[0] = arr[s.length() / 2];
            return new String(answer); 
        }
    }
}