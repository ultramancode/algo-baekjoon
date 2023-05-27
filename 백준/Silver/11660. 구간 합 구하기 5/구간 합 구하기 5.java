import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int n = Integer.parseInt(stringTokenizer.nextToken());
    int m = Integer.parseInt(stringTokenizer.nextToken());

    int[][] arr = new int[n + 1][n + 1];
    int[][] sumArr = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for (int j = 1; j <= n; j++) {
        arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }

    for (int j = 1; j <= n; j++) {
      for (int k = 1; k <= n; k++) {
        sumArr[j][k] = sumArr[j - 1][k] + sumArr[j][k - 1] - sumArr[j - 1][k - 1]
            + arr[j][k]; //아 마지막 원본배열인 arr인데 합배열로해서 자꾸 이상하게 됐네
      }
    }

    for (int k = 0; k < m; k++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());

      int x1 = Integer.parseInt(stringTokenizer.nextToken());
      int y1 = Integer.parseInt(stringTokenizer.nextToken());
      int x2 = Integer.parseInt(stringTokenizer.nextToken());
      int y2 = Integer.parseInt(stringTokenizer.nextToken());
      //x1이 아니라 x1-1 y1-1 이런식으로 ㅡㅡ.. 그 위옆을 빼야하니 헷갈리면 그려보자
      int answer =
          sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1];
      System.out.println(answer);
    }
  }
}