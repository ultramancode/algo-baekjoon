class Solution {
    public long solution(int n) {

        // 조심.. n이 1,2인 경우
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] arr = new long[n];
        arr[0] = 1;
        arr[1] = 2;
        
        for(int i = 2; i<n; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567; 
        }
        return arr[n-1]%1234567;
    }
}