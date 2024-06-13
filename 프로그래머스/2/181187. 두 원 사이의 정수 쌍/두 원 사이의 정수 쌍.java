import java.util.*;

class Solution {
    public long solution(int innerRadius, int outerRadius) {
        long totalPoints = 0;
        
        double innerRadiusSquared = Math.pow(innerRadius, 2);
        double outerRadiusSquared = Math.pow(outerRadius, 2);
        
        int boundaryPoints = (outerRadius - innerRadius + 1) * 4; // 선 위에 있는 좌표 개수
        
        for (int x = 0; x <= outerRadius; x++) { // 1사분면만 계산
            double xSquared = Math.pow(x, 2);
            
            double yMin = 0;
            if (x <= innerRadius) {
                yMin = Math.sqrt(innerRadiusSquared - xSquared); // 작은 원의 y 값
                if (yMin > Math.floor(yMin)) {
                    yMin = Math.ceil(yMin);
                }
            }
            
            double yMax = Math.sqrt(outerRadiusSquared - xSquared); // 큰 원의 y 값
            if (yMax > Math.floor(yMax)) {
                yMax = Math.floor(yMax);
            }
            
            totalPoints += (int)yMax - (int)yMin + 1;
        }
    
        return totalPoints * 4 - boundaryPoints; // 중복 계산된 점 빼주기
    }
}
