class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int sx = 0;
        int sy = 0;
        
        char[][] arr = new char[park.length][park[0].length()];
        
        for(int i =0; i<park.length; i++){
            arr[i] = park[i].toCharArray();
            if(park[i].contains("S")){
                sx = park[i].indexOf("S");
                sy = i;
            }
        }
        for(String route : routes){
            String direction = route.split(" ")[0];
            int move = Integer.parseInt(route.split(" ")[1]);
            
            int nx = sx;
            int ny = sy;
            
            for(int i = 0; i < move; i++){
                if(direction.equals("E")){
                    nx++;
                }
                else if(direction.equals("W")){
                    nx--;
                }
                else if(direction.equals("S")){
                    ny++;
                }
                else if(direction.equals("N")){
                    ny--;
                }
                if(0 <= nx && nx < arr[0].length 
                   && 0 <= ny &&  ny < arr.length){
                    if(arr[ny][nx] == 'X'){
                        break;
                    }
                    // 끝까지 간 경우, 인덱스니 -1
                    if(i == move-1){
                        sx = nx;
                        sy = ny;
                    }
                }
            }
        }
        int[] answer = {sy, sx};
        return answer;
    }
}
