import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.naming.LinkLoopException;

public class Main {

  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static int N;
  static int M;

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    N = Integer.parseInt(stringTokenizer.nextToken());
    M = Integer.parseInt(stringTokenizer.nextToken());

    arr = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      String line = stringTokenizer.nextToken();
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
      }
    }

    BFS(0, 0);
    System.out.println(arr[N - 1][M - 1]);

  }

  private static void BFS(int i, int j) {

    if (visited[i][j]) {
      return;
    }
    Queue<int[]> queue = new LinkedList<>();
    visited[i][j] = true;

    queue.offer(new int[]{i, j});

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      visited[i][j] = true;
      //상하좌우 돌기. 0: y만 1 증가, 1: x 1증가, 2: y 1감소, 3: x 1감소
      for (int k = 0; k < 4; k++) {
        int x = now[0] + dx[k];
        int y = now[1] + dy[k];
        if (x >= 0 && y >= 0 && x < N && y < M) {
          //문제에서 못간다고 했던 0 제외, 갔던 곳 제외
          if (arr[x][y] != 0 && !visited[x][y]) {
            //갈 수 있는 곳들
            visited[x][y] = true;
            arr[x][y] = arr[now[0]][now[1]] + 1; //중요 뎁스 추가!!
            //뎁스 추가하고나서 offer
            queue.offer(new int[]{x, y});
          }
        }

      }
    }


  }

}