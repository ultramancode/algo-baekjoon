class Solution {
    boolean solution(String s) {
        
        
        boolean answer = false;
int countP = 0;
        int countY = 0;
        
        char[] charArr = s.toUpperCase().toCharArray();
        for(int i = 0; i<charArr.length; i++){
            if(charArr[i] == 'Y'){
countY++;}else if(charArr[i] == 'P'){
                countP++;
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        if(countP == countY){
            answer = true;
        }

        return answer;
    }
}