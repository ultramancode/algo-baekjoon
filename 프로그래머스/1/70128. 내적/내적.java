class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        int[] arr = new int[a.length];
        
        for(int i = 0; i<a.length; i++){
        answer += a[i]*b[i];
        }
        
        
        return answer;
    }
}