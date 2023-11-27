class Solution {
    public int solution(String t, String p) {
        if (t == null || p == null || t.isEmpty() || p.isEmpty()) {
            return 0; // 빈 문자열이나 null이 입력되었을 때 처리
        }

        int answer = 0;
        long pLong = Long.parseLong(p);

        for (int i = 0; i <= t.length() - p.length(); i++) {
            String subStr = t.substring(i, i + p.length());
            long subStrLong = Long.parseLong(subStr);

            if (subStrLong <= pLong) {
                answer++;
            }
        }

        return answer;
    }
}
