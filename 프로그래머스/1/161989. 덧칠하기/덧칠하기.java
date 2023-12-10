class Solution {
    public int solution(int n, int m, int[] section) {

        int tmp = 0;
        int answer =0;

        for(int i=0; i<section.length; i++){
            if(tmp < section[i]){
                answer++;
                tmp = section[i]+m-1;
            } else continue;
        }
         return answer;
}
}