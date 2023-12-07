class Solution {
    public int solution(int n) {
        int answer = 0;
        
        //<(x) <=(o)
        for(int i =2; i<=n; i++){
            if(isPrime(i)){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(int num){
        if(num<2){
            return false;
        }
        for(int i = 2; i<=Math.sqrt(num); i++){
        if((num%i)==0){
            return false;
        }
        }
        return true;
    }
}