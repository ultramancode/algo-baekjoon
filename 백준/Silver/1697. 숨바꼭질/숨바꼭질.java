import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(bfs(N, K));

    }

    static int bfs(int N, int K) {

        Queue<Integer> queue = new LinkedList<>();

        int[] visited = new int[100001];

        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            if(current == K){
                return visited[current] -1;
            }
            if (current -1 >= 0 && visited[current-1] == 0) {
                visited[current-1] = visited[current]+1;
                queue.add(current-1);
            }
            if (current +1 <= 100000 && visited[current+1] == 0){
                visited[current+1] = visited[current]+1;
                queue.add(current+1);
            }
            if (current *2 <= 100000 && visited[current*2] == 0){
                visited[current*2] = visited[current]+1;
                queue.add(current*2);
            }
        }
        return -1;
    }
}
