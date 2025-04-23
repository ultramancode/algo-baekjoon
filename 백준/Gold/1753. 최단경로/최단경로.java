
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V;
    static int E;
    static int K;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(bufferedReader.readLine());

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];

        // 정점
        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }


        // 간선
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
        }

        dijkstra(K);

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }


    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.totalDistance));
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int nodeId = curr.nodeId;

            if (curr.totalDistance > dist[nodeId]) {
                continue;
            }

            for (Edge currEdge : graph[nodeId]) {
                int to = currEdge.to;
                int totalDistance = dist[nodeId] + currEdge.weight;

                if (totalDistance < dist[to]) {
                    dist[to] = totalDistance;
                    pq.offer(new Node(to, totalDistance));
                }
            }
        }
    }


    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static class Node {
        // 현재 정점
        int nodeId;
        // 현재 정점까지의 누적 거리
        int totalDistance;

        public Node(int nodeId, int totalDistance) {
            this.nodeId = nodeId;
            this.totalDistance = totalDistance;
        }
    }
}
