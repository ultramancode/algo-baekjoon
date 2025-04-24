
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(map);
        boolean check = false;

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0){
                    check=true;
                }
                result = Math.max(result, map[i][j]);
            }
        }

        System.out.println(check ? -1 :  result-1);
    }

    static void bfs(int[][] map) {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new Point(j, i));
                }
            }
        }


        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }
                if (map[ny][nx] != 0) {
                    continue;
                }

                map[ny][nx] = map[curr.y][curr.x] + 1;

                queue.offer(new Point(nx, ny));
            }
        }
    }


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
