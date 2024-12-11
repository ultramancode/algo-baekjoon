class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 0;
        int right = 100000;
        int level = 0;
        while (left <= right) {
            int mid = (left+right)/2;
            if (canSolve(diffs, times, limit, mid)) {
                level = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 숙련도 양의 정수라고 명시돼있음..
        return level > 0 ? level : 1;
    }
    
    public static boolean canSolve(int[] diffs, int[] times, long limit, int mid) {
        long sumTime = 0;
        for (int i = 0; i < diffs.length; i++) {
            if(diffs[i] <= mid) {
                sumTime += times[i];
            } else {
                int mistake = diffs[i] - mid;
                long prevTime = i > 0 ? times[i - 1] : 0;
                sumTime += mistake * (prevTime + times[i]) + times[i];
            }

            if(sumTime > limit){
                return false;
            }
        }
        return true;
    }
}