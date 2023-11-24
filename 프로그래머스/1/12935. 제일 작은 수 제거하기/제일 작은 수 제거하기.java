import java.util.*;
class Solution {
      public int[] solution(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }
        int min = Arrays.stream(arr).min().getAsInt(); 
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (num != min) {
                list.add(num); 
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}