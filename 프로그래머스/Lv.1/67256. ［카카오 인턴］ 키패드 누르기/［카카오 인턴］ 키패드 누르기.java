import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {

        StringBuilder answer = new StringBuilder();
        // * 
        int leftHand = 10;
        // #
        int rightHand = 12;
        for(int number : numbers) {
            
            if(number == 1 || number == 4 || number == 7){
                answer.append("L");
                leftHand = number;
            }else if ( number == 3 || number == 6 || number == 9){
                answer.append("R");
                rightHand = number;
            }else {
                if(number == 0){
                    number = 11;
                } 
                int leftLength 
                    = (Math.abs(number-leftHand))/3 
                    + (Math.abs(number-leftHand))%3;
                int rightLength
                    = (Math.abs(number-rightHand))/3 
                    + (Math.abs(number-rightHand))%3;
                if(leftLength > rightLength){
                    rightHand = number;
                    answer.append("R");
                }else if(rightLength > leftLength){
                    leftHand = number;
                    answer.append("L");
                }else if(rightLength == leftLength){
                    if(hand.equals("left")){
                        leftHand = number;
                        answer.append("L");
                    }else if(hand.equals("right")){
                        rightHand = number;
                    answer.append("R");
                    }
                }
            }
            
        }
        return answer.toString();
    }
}