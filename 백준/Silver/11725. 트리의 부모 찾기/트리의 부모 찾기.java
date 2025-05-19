
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] tree = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        int[] parent = new int[N + 1];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        parent[1] = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int child : tree[current]) {
                if (parent[child] == 0) {
                    parent[child] = current;
                    queue.add(child);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N + 1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
}
