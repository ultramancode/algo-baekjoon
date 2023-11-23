class Solution {
    public long solution(long n) {
        double sqrt = Math.floor(Math.sqrt(n));
        if (sqrt * sqrt == n) { 
            return (long)((sqrt + 1) * (sqrt + 1));
        } else {
            return -1;
        }
    }
}