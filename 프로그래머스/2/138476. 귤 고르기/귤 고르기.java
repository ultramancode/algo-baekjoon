import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // Map에 귤의 크기별 개수 담기
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());

        keyList.sort(
            ((o1, o2) -> {
            return map.get(o2) - map.get(o1);
        })
        );


        for (Integer i : keyList) {
            if (k <= 0) {
                break;
            }

            answer++;
            k -= map.get(i);
        }

        return answer;
    }
}
