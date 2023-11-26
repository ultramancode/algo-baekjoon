class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = n;
        String threeStr = "";

        // 10진수를 거꾸로 3진수로 변환
        while (num > 0) {
            int three = num % 3;
            threeStr = threeStr + three;
            num /= 3;
        }

        // 3진수를 다시 10진수로 변환
        int length = threeStr.length();
        int power = 1;
        for (int i = length - 1; i >= 0; i--) {
            int digit = threeStr.charAt(i) - '0'; // 조심
            answer += digit * power; 
            power *= 3;
        }

        return answer;
    }
}
