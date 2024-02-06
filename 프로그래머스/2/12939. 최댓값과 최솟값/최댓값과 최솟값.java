import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<Integer> numbers = new ArrayList<>();
        String[] arr = s.split(" ");

        for (String str : arr) {
            int num = Integer.parseInt(str);
            numbers.add(num);
        }

        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        for (int num : numbers) {
            if (num > maxNum) {
                maxNum = num;
            }
            if (num < minNum) {
                minNum = num;
            }
        }

        answer = minNum + " " + maxNum;
        return answer;
    }
}
