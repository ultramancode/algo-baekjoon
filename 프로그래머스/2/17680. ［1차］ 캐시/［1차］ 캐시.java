import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 순서 활용..링크드해시셋 이용
        Set<String> cacheSet = new LinkedHashSet<>();
        int cacheTime = 0;

        if (cacheSize == 0){
            return (cities.length)*5;
        }
        for (String city : cities) {
            city = city.toLowerCase();

            if (cacheSet.contains(city)) {
                cacheTime += 1;
                cacheSet.remove(city);
                cacheSet.add(city);
            } else {
                cacheTime += 5;
                if (cacheSet.size() >= cacheSize) {
                    if(cacheSet.iterator().hasNext()){
                    String oldestCity = cacheSet.iterator().next();
                    cacheSet.remove(oldestCity);
                    }
                }
                cacheSet.add(city);
            }
        }

        return cacheTime;
    }
}
