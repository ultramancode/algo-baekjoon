import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
    
        int[] fails = new int[N];
        int[] users = new int[N];
        
        for(int stage : stages){
            if(stage != N+1){
                fails[stage -1]++;
            for(int i =0; i<stage; i++){
                users[i] ++;
                }  
            }else{ 
             for(int i =0; i<users.length; i++){
                users[i]++;
                }
             }
         }
        ArrayList<Double[]> failRate = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            double rate = 
                Double.isNaN ((double)fails[i]/users[i]) ? 0 : (double)fails[i]/users[i];
            failRate.add(new Double[]{
                (double)i+1,rate
            });
        }
                
            failRate.sort((o1,o2) -> Double.compare(o2[1],o1[1]));
                          return failRate.stream().mapToInt(value -> value[0].intValue()).toArray();
            
}
}