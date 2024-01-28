import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        ArrayList<String[]> arr = new ArrayList<>();
        int sx = 50;
        int sy = 50;
        int ex = 0;
        int ey = 0;
        for(int i = 0; i<wallpaper.length; i++){
            for(int j =0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#' && sy > j){
                    sy = j;
                } 
                if (wallpaper[i].charAt(j)=='#' && ey < j+1){
                    ey = j+1;
                }
                if(wallpaper[i].charAt(j)=='#' && sx > i){
                    sx = i;
                }
                if (wallpaper[i].charAt(j)=='#' && ex < i+1){
                    ex = i+1;
                }
            }
        }
                int[] answer = {sx,sy,ex,ey};

        
        
        
        return answer;
    }
}