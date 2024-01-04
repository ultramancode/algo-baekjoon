import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int currentCnt = 0;

        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i =0; i<keymap.length; i++){
            for(int j =0; j<keymap[i].length(); j++){
                if(map.containsKey(keymap[i].charAt(j))){
                    currentCnt = map.get(keymap[i].charAt(j));
                    if(currentCnt>(j+1)){
                        map.put(keymap[i].charAt(j),j+1);
                    }
                } else { 
                    map.put(keymap[i].charAt(j),j+1);
                    }
            }
        }
        for(int i = 0; i<targets.length; i++){
            int count = 0;
            for(int j=0; j<targets[i].length(); j++){
                Integer minCnt = map.get(targets[i].charAt(j));
                if(minCnt != null){
                    count+=minCnt;
                }else{
                    count = -1;
                    break;
                }
            }
            answer[i]=count;
        }
        return answer;
    }
}