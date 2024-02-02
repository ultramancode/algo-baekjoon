import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int friendsLenght = friends.length;
        
        Map<String, Integer> map = new HashMap<>();
        
        int[] giftScore = new int[friendsLenght];
        int[][] giftScoreBetween = new int[friendsLenght][friendsLenght];
        
        for ( int i = 0; i < friendsLenght; i++ ) {
            map.put(friends[i], i);
        }
        
        for ( String gift : gifts ) {
            String[] giftName = gift.split(" ");
            giftScore[map.get(giftName[0])]++;
            giftScore[map.get(giftName[1])]--;
            giftScoreBetween[map.get(giftName[0])][map.get(giftName[1])]++;    
        }
        
        for ( int i =0; i< friendsLenght; i++) {
            int num = 0;
            for ( int j = 0; j< friendsLenght; j++) {
                if ( i == j) {
                    continue;
                }    
                
                if (giftScoreBetween[i][j] > giftScoreBetween[j][i] ||
                     (giftScoreBetween[i][j] == giftScoreBetween[j][i] 
                      && giftScore[i] > giftScore[j])) {
                        num++;
                    }
            }
            
            if ( answer < num) {
                answer = num;
            }
            
        }
        
        return answer;
    }
}