import java.util.*;
class Solution {
    public int solution(int n) {

        List<Integer> answerList = new ArrayList<>();
       
        
        for(int i = 2; i < n; i++){
            if(n % i == 1){
                answerList.add(i);
            }
        }
        if(answerList.isEmpty()){
            return 0;
        }else return Collections.min(answerList);
    }
}