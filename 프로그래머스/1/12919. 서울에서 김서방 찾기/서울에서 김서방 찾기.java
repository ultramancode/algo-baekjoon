class Solution {
    public String solution(String[] seoul) {
        int j = 0;
        String answer = "";

        for(int i = 0; i<seoul.length; i++){
            if("Kim".equals(seoul[i])){
                j = i;
            }
        }
        answer = "김서방은 "+j+"에 있다";

                                return answer;

        
    }
}