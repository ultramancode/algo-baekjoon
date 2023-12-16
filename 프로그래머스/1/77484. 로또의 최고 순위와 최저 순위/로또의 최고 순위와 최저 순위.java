import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int max = 0;
        int min = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for (int lotto : lottos) {
            arr.add(lotto);
        }

        for (int win_num : win_nums) {
            if (arr.contains(win_num)) {
                //인덱스 기준으로 삭제 안하고 값을 기준으로 삭제 하고싶으면 Integer.valueOf로 ! 
                arr.remove(Integer.valueOf(win_num)); 
                count++;
            }
        }
        min = count;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) {
                max++;
                arr.remove(i);
                i--; // 리스트 요소를 제거하면 인덱스를 조정해야 함, 안그러면 에러터짐!!
            }
        }

        answer[0] = (max == 0 && count == 0) ? 6 : 7 - (max + min);
        answer[1] = (min == 0) ? 6 : 7 - min; // 최소 등수 계산

        return answer;
    }
}
