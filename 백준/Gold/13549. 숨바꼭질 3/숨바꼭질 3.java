
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
    static int N;
    static int K;
    static int MAX = 100001;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner((System.in));

        N = sc.nextInt();
        K = sc.nextInt();

        int visited[] = new int[MAX];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[N] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1.time, o2.time)));
        pq.offer(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.position == K) {
                System.out.println(curr.time);
                return;
            }

            // *2
            int next = curr.position * 2;
            if (next < MAX && visited[next] > curr.time) {
                visited[next] = curr.time;
                pq.offer(new Node(next, curr.time));
            }

            // +1
            next = curr.position+1;
            if(next<MAX && visited[next] > curr.time+1){
                visited[next] = curr.time+1;
                pq.offer(new Node(next, curr.time+1));
            }

            // -1
            next = curr.position-1;
            if(next >= 0 && visited[next] > curr.time+1){
                visited[next] = curr.time+1;
                pq.offer(new Node(next, curr.time+1));
            }
        }
    }
    static class Node {
        int position;
        int time;

        public Node(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }
}
