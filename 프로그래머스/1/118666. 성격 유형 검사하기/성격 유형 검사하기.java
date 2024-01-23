import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i =0; i<survey.length; i++){
            String[] surveyArr = survey[i].split("");
            if(choices[i] == 1 || choices[i] == 2 || choices[i] == 3){
                map.put(surveyArr[0], 
                        map.getOrDefault(surveyArr[0],0)+ 4 - choices[i]);
            }
            else if(choices[i] == 5 || choices[i] == 6 || choices[i] == 7){
                map.put(surveyArr[1],
                        map.getOrDefault(surveyArr[1],0) + choices[i] -4);
            }
        }
        StringBuilder answer = new StringBuilder();
        
        
        answer
            .append(map.getOrDefault("R",0)>=map.getOrDefault("T",0)? "R" : "T")
            .append(map.getOrDefault("C",0)>=map.getOrDefault("F",0)? "C" : "F")
            .append(map.getOrDefault("J",0)>=map.getOrDefault("M",0)? "J" : "M")
            .append(map.getOrDefault("A",0)>=map.getOrDefault("N",0)? "A" : "N");
        
            return answer.toString();
    }
}