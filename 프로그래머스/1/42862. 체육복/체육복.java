import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();
        
        for (int r : reserve) {
            reserveSet.add(r);
        }
        
        for (int l : lost) {
            if (reserveSet.contains(l)) {
                reserveSet.remove(l);
                answer++;
            } else {
                lostSet.add(l);
            }
        }
        
        for (int l : lostSet) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
                answer++;
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
                answer++;
            }
        }
        
        return answer;
    }
}
