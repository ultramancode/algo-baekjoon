import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportedUsers = new HashMap<>();
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, Integer> resultCount = new HashMap<>();

        // 유저가 신고한 유저 목록과 신고 횟수 계산
        for (String reportData : report) {
            String[] splitData = reportData.split(" ");
            String reporter = splitData[0];
            String reportedUser = splitData[1];

            if (!reportedUsers.computeIfAbsent(
                reportedUser, key -> new HashSet<>()).contains(reporter)
               ) {
                reportedUsers.get(reportedUser).add(reporter);
                reportCount.put(reportedUser, 
                                reportCount.getOrDefault(reportedUser, 0) + 1);
            }
        }

        // 정지된 유저 확인
        Set<String> suspendedUsers = new HashSet<>();
        for (String user : reportCount.keySet()) {
            if (reportCount.get(user) >= k) {
                suspendedUsers.add(user);
            }
        }

        // // 결과 메일을 받은 횟수 계산
        // for (String suspendedUser : suspendedUsers) {
        //     Set<String> reporters = reportedUsers
        //         .getOrDefault(suspendedUser, new HashSet<>());
        //     for (String reporter : reporters) {
        //         resultCount
        //             .put(reporter, resultCount.getOrDefault(reporter, 0) + 1);
        //     }
        // }
         // 정지된 유저 확인 및 결과 메일 횟수 계산
        for (String user : reportCount.keySet()) {
            if (reportCount.get(user) >= k) {
                reportedUsers.get(user)
                    .forEach(
                    reporter -> 
                    resultCount
                    .put(reporter, resultCount.getOrDefault(reporter, 0) + 1)
                );
            }
        }

        // 배열로 변환
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = resultCount.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}
