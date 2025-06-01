

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[] visited;
    static ArrayList<Node>[] tree;
    static int maxDist = 0;
    static int farthestNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());


        tree = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }


        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[from].add(new Node(to, weight));
            tree[to].add(new Node(from, weight));
        }


        // 임의 노드에서 제일 먼 노드
        visited = new boolean[N + 1];
        dfs(1, 0);

        // 제일 먼 노드에서 또 제일 먼 노드
        visited = new boolean[N + 1];
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);


    }

    static void dfs(int node, int dist) {
        visited[node] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }

        for (Node neighbor : tree[node]) {
            if (!visited[neighbor.to]) {
                dfs(neighbor.to, dist + neighbor.weight);
            }
        }


    }

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
