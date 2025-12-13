import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visited;
    static int answer = 0;

    // 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        // 숫자판 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false;

                // T모양 따로 처리
                checkTShape(i, j);
            }
        }

        System.out.println(answer);
    }
    static void dfs(int r, int c, int depth, int sum) {
        if (depth == 4) {
            if (sum > answer) {
                answer = sum;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                continue;
            }

            if (visited[nr][nc]) {
                continue;
            }

            visited[nr][nc] = true;
            dfs(nr, nc, depth + 1, sum + board[nr][nc]);
            visited[nr][nc] = false;
        }
    }

    // T 모양: 중심 + 날개 3개
    static void checkTShape(int r, int c) {
        int center = board[r][c];

        int wings = 0;
        int sum = center;
        int minWing = Integer.MAX_VALUE;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                continue;
            }

            int val = board[nr][nc];
            sum += val;
            wings++;
            if (val < minWing) {
                minWing = val;
            }
        }

        // 날개가 3개 미만이면 T 모양 불가
        if (wings < 3) {
            return;
        }

        // 날개 3개인 경우: 그대로 사용
        if (wings == 3) {
            if (sum > answer) {
                answer = sum;
            }
        }
        // 날개 4개인 경우: 하나를 빼서 T 모양 만들기 (가장 작은 날개 빼기)
        else if (wings == 4) {
            int candidate = sum - minWing;
            if (candidate > answer) {
                answer = candidate;
            }
        }
    }
}
