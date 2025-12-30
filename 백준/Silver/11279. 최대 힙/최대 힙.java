import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x != 0) {
                pq.add(x);
            } else {
                if (pq.size() == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
        }

    }
}
