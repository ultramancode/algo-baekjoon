import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        for(int i = 0; i<completion.length; i++){
            map.put(completion[i], map.getOrDefault(completion[i],0)+1);
        } 
        for(String name : participant){
            if(!map.containsKey(name) || map.get(name) == 0){
                answer = name;

            } else {
                map.put(name, map.get(name)-1);
            }
        }
        return answer;
    }
}