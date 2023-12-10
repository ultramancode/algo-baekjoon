class Solution {
    static int arr[] = new int[100001];

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (arr[i] == 0) {
                arr[i] = divisorNumber(i);
            }
            if (arr[i] <= limit) {
                answer += arr[i];
            } else {
                answer += power;
            }
        }
        return answer;
    }

    public int divisorNumber(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                count++;
                if (i != num / i) {
                    count++;
                }
            }
        }
        return count;
    }
}