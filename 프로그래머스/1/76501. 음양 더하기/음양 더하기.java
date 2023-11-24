class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        long[] arr = new long[absolutes.length];
        for(int i = 0; i<absolutes.length; i++){
            int a = 0;
            if(signs[i]==(true)){
            a = absolutes[i];    
            }else {
                a = absolutes[i]*-1;
        }
            answer += a;
        }
        
        return answer;
    }
}