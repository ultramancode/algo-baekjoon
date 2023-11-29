import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<commands.length; i++){
            int[] commandsArr = commands[i];
            int[] subArr = Arrays.copyOfRange(
                array, commandsArr[0]-1, commandsArr[1]);
            Arrays.sort(subArr);
            arr.add(subArr[commandsArr[2]-1]);
        }           
        int[] answer = new int[arr.size()];

        for(int i =0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}