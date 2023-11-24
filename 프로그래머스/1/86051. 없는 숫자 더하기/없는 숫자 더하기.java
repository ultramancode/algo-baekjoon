class Solution {
    public int solution(int[] numbers) {
        int num = 1+2+3+4+5+6+7+8+9;
    
        for(int i = 0; i<numbers.length; i++){
                num-=numbers[i];
            }
         return num;
        }
}