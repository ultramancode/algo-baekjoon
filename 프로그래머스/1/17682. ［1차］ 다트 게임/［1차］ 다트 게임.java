class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] arr = dartResult.toCharArray();
        int[] score = new int[3];
        int scoreIdx = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '1' && arr[i+1] =='0'){
                scoreIdx ++;
                score[scoreIdx] = 10;
                i++;// arr[i+1]
                continue;
            }else if(arr[i] >= '0' && arr[i] <= '9'){
                scoreIdx ++;
                score[scoreIdx] = Integer.parseInt(String.valueOf(arr[i]));     
                continue;
            }
            // 컨티뉴로 문자열 이어서 파싱
            switch(arr[i]){
            case 'D':
                score[scoreIdx] = (int)Math.pow(score[scoreIdx],2);
                    break;
            case 'T':
                score[scoreIdx] = (int)Math.pow(score[scoreIdx],3);
                    break;
            case '*':
                score[scoreIdx] = score[scoreIdx]*2;
              if (scoreIdx-1>=0) {
                        score[scoreIdx-1]*=2;
                    }
                break;
            case '#':
                score[scoreIdx] = score[scoreIdx]*-1;
           }
        }
        for(int i =0; i<score.length; i++){
            answer+=score[i];
        }
        return answer;
    }
}
