class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long tmp = 0;
        
        for(int i = 1; i<=count; i++){
            tmp += i * price;
        }
        long nMoney = tmp - money;
        if(nMoney>0){
            return nMoney;
        }else return 0;
    }
}