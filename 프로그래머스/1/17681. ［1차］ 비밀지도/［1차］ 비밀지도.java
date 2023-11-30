import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String binaryMap = Integer.toBinaryString(arr1[i] | arr2[i]);
            binaryMap = String.format("%" + n + "s", binaryMap);
            binaryMap = binaryMap.replaceAll("1", "#");
            binaryMap = binaryMap.replaceAll("0", " ");
            answer[i] = binaryMap;
        }
        return answer;
    }
}
