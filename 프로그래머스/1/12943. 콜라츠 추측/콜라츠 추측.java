class Solution {
    public int solution(int num) {
        long answer = num; // int 대신 long을 사용하여 오버플로우 방지
        
        int i;
        for (i = 0; i < 500; i++) {
            if (answer == 1) {
                break;
            }
            if (answer % 2 == 0) {
                answer /= 2;
            } else {
                answer = answer * 3 + 1;
            }
        }
        
        if (answer == 1) {
            return i;
        } else {
            return -1;
        }
    }
}