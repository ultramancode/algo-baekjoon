class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 노란색 격자로 만들어진 카펫의 가로 길이와 세로 길이를 구하기
        for(int i = 1; i <= yellow; i++) {
            //노랑색 기준이니 i로 나눠지는지 (yellow/i) * i = yellow 돼야하니까
            if(yellow % i == 0) {
                //x*y가 yellow니까 + x가 더크니까 처음 나온 i로 나눈 값을 x로
                //구해야하는건 전체 배열이니 노랑색+2
                int x = yellow / i + 2;
                int y = i + 2;
                
                // 카펫의 가로와 세로 길이를 이용하여 갈색 격자의 수 확인(제일 바깥쪽 1줄)
                // 그리고 각 테두리 끝 4개는 겹치는 부분이니 제거
                if(2*x + 2*y - 4 == brown) {
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
        }
        
        return answer;
    }
}
