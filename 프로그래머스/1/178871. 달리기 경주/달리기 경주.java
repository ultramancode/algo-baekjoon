import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
    
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<players.length; i++){
            map.put(players[i],i);
        }
        
        for(String player : callings){
            int nowIndex = map.get(player);
            String beforePlayer = players[nowIndex-1];
            
            players[nowIndex-1] = player;
            players[nowIndex] = beforePlayer;
            
            map.put(player,nowIndex-1);
            map.put(beforePlayer,nowIndex);
        }
        return players;
    }
}
   