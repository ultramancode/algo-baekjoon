import java.util.*;
class Solution {
    public String solution(String X, String Y) {

        
  Map<String, Integer> mapX = new HashMap<>();
  Map<String, Integer> mapY = new HashMap<>();
    
    for(String key : X.split("")){
        mapX.put(key,mapX.getOrDefault(key,0)+1);
    }
    for(String key : Y.split("")){
        mapY.put(key,mapY.getOrDefault(key,0)+1);
    }
    ArrayList<String> arr = new ArrayList<>();
    for(String key: mapX.keySet()){
        if(!mapY.keySet().contains(key)){
        continue;
        }
        int occurrences = Math.min(mapX.get(key),mapY.get(key));
        for(int i=0; i<occurrences; i++){
        arr.add(key);
        }
    }   
        Collections.sort(arr,Collections.reverseOrder());

        StringBuilder answer = new StringBuilder();
        for (String num : arr) {
            answer.append(num);
        }

        if(answer.length() == 0){
            return "-1";
            
            //조심.. 0,"0" 안돼 char니까 
        }else if(answer.charAt(0) == '0'){
            return "0";
        }
        return answer.toString();

        }
}
