class Solution {
    public int solution(int n) {
        int answer = n+1;

        while(true){
            if(answer > n && isOneNum(n,answer)){
                break;
            }else {
            answer++;
            }
        }
        return answer;
    }
        public boolean isOneNum(int n, int next){
            String binaryN = Integer.toBinaryString(n);
            String binaryNext = Integer.toBinaryString(next);
            
    int countN = 0;
    int countNext = 0;

    for (int i = 0; i < binaryN.length(); i++) {
        if (binaryN.charAt(i) == '1') {
            countN++;
        }
    }
    for (int i = 0; i < binaryNext.length(); i++) {
        if (binaryNext.charAt(i) == '1') {
            countNext++;
        }
    }

    return countN == countNext;
        }
    }
