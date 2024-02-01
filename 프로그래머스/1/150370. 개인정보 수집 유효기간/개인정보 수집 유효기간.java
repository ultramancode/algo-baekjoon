import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> periodMap = new HashMap<>();


        for (String term : terms) {
            String[] parts = term.split(" ");
            periodMap.put(parts[0], Integer.parseInt(parts[1]));
        }


        int todayDays = getDay(today);
        ArrayList<Integer> resultArrayList = new ArrayList<>();


        for (int i = 0; i < privacies.length; i++) {
            String[] privacyParts = privacies[i].split(" ");
            int privacyDays = getDay(privacyParts[0]);


            int expirationDays = privacyDays + periodMap.get(privacyParts[1]) * 28;


            if (todayDays >= expirationDays) {
                resultArrayList.add(i + 1);
            }
        }


        int[] answer = new int[resultArrayList.size()];
        for (int i = 0; i < resultArrayList.size(); i++) {
            answer[i] = resultArrayList.get(i);
        }

        return answer;
    }

    // 날짜를 일 수로 변환하는 메소드
    private int getDay(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return year * 12 * 28 + month * 28 + day;
    }
}
