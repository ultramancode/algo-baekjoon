
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int targetY;
    static int targetX;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0,};


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    targetY = i;
                    targetX = j;
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.print(0 + " ");
                } else if (!visited[i][j]) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{targetX, targetY});

        visited[targetY][targetX] = true;

        dist[targetY][targetX] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }

                if (visited[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] == 0) {
                    continue;
                }
                visited[ny][nx] = true;
                dist[ny][nx] = dist[nowY][nowX] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}
