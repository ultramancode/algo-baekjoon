import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> alreadyWords = new HashSet<>();
        char lastChar = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {

            if (alreadyWords.contains(words[i])) {
                return new int[]{i % n + 1, i / n + 1};
            }

            alreadyWords.add(words[i]);


            if (lastChar != words[i].charAt(0)) {
                return new int[]{i % n + 1, i / n + 1};
            }

            lastChar = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0, 0};
    }
}
