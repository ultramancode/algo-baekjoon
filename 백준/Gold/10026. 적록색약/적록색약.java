import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();
            map[i] = line.toCharArray();
        }


        visited = new boolean[N][N];
        int normalCnt = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x]) {
                    dfs(y, x, map[y][x]);
                    normalCnt++;
                }
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 'G') {
                    map[y][x] = 'R';
                }
            }
        }

        visited = new boolean[N][N];
        int blindCnt = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x]) {
                    dfs(y, x, map[y][x]);
                    blindCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + blindCnt);

    }

    static void dfs(int y, int x, char color) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
                if (!visited[ny][nx] && map[ny][nx] == color) {
                    dfs(ny, nx, color);
                }
            }
        }
    }
}


