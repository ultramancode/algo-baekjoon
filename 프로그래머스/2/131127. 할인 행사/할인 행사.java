import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 원하는 거 저장하는 map
        Map<String, Integer> listMap = new HashMap<String, Integer>();
        for (int i = 0; i < want.length; i++) {
            listMap.put(want[i], number[i]);
        }
        // 슬라이딩 윈도우로 10일씩 확인해보자
        for (int i = 0; i <= discount.length - 10; i++) {

            Map<String, Integer> discountMap = new HashMap<String, Integer>();

            for (int j = 0; j < 10; j++) {
                discountMap.put(discount[i + j], 
                                discountMap.getOrDefault(discount[i + j], 0) + 1);
            }

            boolean match = true;

            for (String key : listMap.keySet()) {
                if (!listMap.get(key).equals(discountMap.getOrDefault(key,0))) {
                    match = false;
                    break;
                }
            }

            if (match == true) {
                answer++;
            }
        }
        return answer;
    }
}