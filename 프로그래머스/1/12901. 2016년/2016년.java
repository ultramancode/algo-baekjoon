class Solution {
    public String solution(int a, int b) {

        String[] daysOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] daysOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        //days에 +해줄거니까 0일로 하자.. 1말고 
        int days = 0;
        for (int i = 0; i < a-1; i++) {
            days += daysOfMonth[i];
        }
        //나머지 인덱스가 0부터 시작이니
        //ex) 1월1일은 그냥 b로하면 나머지 1이 되면서 SAT가 될테니 -1해주기
        days += b-1;
        
        int indexOfDay = days % 7;
        return daysOfWeek[indexOfDay];
    }
}