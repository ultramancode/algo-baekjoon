import java.util.*;
class Solution {
      public int solution(int[] people, int limit) {
          
          Arrays.sort(people);
          int answer = 0;
          int left = 0;
          int right = people.length-1;
          
          while(left<=right){
              if(people[left] + people[right] <= limit){
                  left++;
              }
              right --;
              // 몸무게 많이 나가면 혼자 보트
              answer++;
          }
          return answer;
      }
}
          
          
          
          
          
          
          
   