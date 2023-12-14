class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains("ayaaya") || babbling[i].contains("yeye")|| 
                babbling[i].contains("woowoo") || babbling[i].contains("mama"))
            {
                continue;
            }
            //yayae같은 경우 방지 위해서, 바로 ""로 안하고 " "로 만들고 없애는 것
            babbling[i] = babbling[i].replace("aya"," ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            // 조심 
            babbling[i] = babbling[i].replace(" ","");

            if(babbling[i].isEmpty()) answer++;
        }
            return answer;
    }
}
