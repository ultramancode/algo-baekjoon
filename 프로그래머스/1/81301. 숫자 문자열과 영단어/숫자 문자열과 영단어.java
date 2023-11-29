import java.util.*;

class Solution {
    public int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        StringBuilder numStr = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                answer.append(ch);
            } else {
                numStr.append(ch);
                if (map.containsKey(numStr.toString())) {
                    answer.append(map.get(numStr.toString()));
                    numStr.setLength(0);
                }
            }
        }

        return Integer.parseInt(answer.toString());
    }
}
