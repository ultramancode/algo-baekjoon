class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isOdd = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') { // 공백을 만나면 단어가 바뀜
                isOdd = true; // 단어가 바뀌면 인덱스 초기화
                answer.append(c); // 공백은 그대로 추가
                continue;
            }

            if (isOdd) { 
                answer.append(Character.toUpperCase(c));
            } else { 
                answer.append(Character.toLowerCase(c));
            }
            isOdd = !isOdd; // 인덱스 전환
        }

        return answer.toString();
    }
}
