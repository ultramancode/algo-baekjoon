class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int num = 0;
        char[] arr = String.valueOf(x).toCharArray();
        for(int i = 0; i<arr.length; i++){
            num += Character.getNumericValue(arr[i]);
        }
        if((x%num) == 0){
            answer = true;
        }
        
        
        return answer;
    }
}