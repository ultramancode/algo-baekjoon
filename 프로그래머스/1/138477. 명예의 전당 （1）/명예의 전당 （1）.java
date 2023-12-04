import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i =0; i<score.length; i++){
            arr.add(score[i]);
            Collections.sort(arr, Collections.reverseOrder());

            if(i<k){
               answer[i] = arr.get(arr.size()-1);
            }else{
                answer[i] = arr.get(k-1);
            }
        }
        
        return answer;
    }
}