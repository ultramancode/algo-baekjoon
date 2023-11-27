class Solution {

    static int count;
    static boolean[] visited;

    public int solution(int[] number) {
        int answer = 0;
        visited = new boolean[number.length];

        dfs(number, number.length, 0, 3); // nCr 3개 고르기
        answer = count;
        return answer;
    }

    public static void dfs(int[] numbers, int n, int start, int r){
        if(r == 0){
            int sum =0;
            for(int i =0 ; i< n; i++){
                if(visited[i]){
                    sum += numbers[i];
                }
            }
            if(sum == 0){
                count++;
            }
            return;
        }

        for(int i = start ; i< n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(numbers, n, i, r-1 );
                visited[i] = false;
            }
        }
    }
}