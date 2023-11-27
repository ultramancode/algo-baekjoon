class Solution {
    public String solution(String s) {
        String answer = "";
        //"try out " 처럼 공백이 있으면 무시하는게 아니라 단어로 취급해야됨
        String[] list = s.split(" ", -1);
        String[] words = new String[list.length];

        for (int i = 0; i < list.length; i++) {
            words[i] = "";
            for (int j = 0; j < list[i].length(); j++) {
                if (j % 2 == 0) {
                    words[i] += Character.toUpperCase(list[i].charAt(j));
                } else {
                    words[i] += Character.toLowerCase(list[i].charAt(j));
                }
            }
        }

        answer = String.join(" ", words);
        return answer;
    }
}
