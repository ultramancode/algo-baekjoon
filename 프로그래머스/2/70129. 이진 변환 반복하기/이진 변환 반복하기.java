class Solution {
    public int[] solution(String s) {
        int zero = 0;
        int change = 0; 
        
        while (!s.equals("1")) {
            int length = s.length();
            s = s.replace("0", "");
            int removedZeros = length - s.length();
            s = Integer.toBinaryString(s.length());
            change++;
            zero += removedZeros;
        }
        return new int[]{change, zero};
    }
}
