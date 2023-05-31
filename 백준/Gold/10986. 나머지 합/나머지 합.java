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

    long answerCnt = 0;
    long[] arrSum = new long[n + 1];
    long[] arrRest = new long[m];
//    int caseCntZero = 0;
//    int caseCntEtc = 0;
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 1; i < n + 1; i++) {

      arrSum[i] = arrSum[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
    }

//    for (int i = 1; i < n + 1; i++) {
//      arrRest[i] = arrSum[i] % m;
//      if (arrRest[i] == 0) {
//        answerCnt++;
//        caseCntZero++;
//      }
//    }
//2중 포문... 시간초과 나버리네 이런..
//    for (int i = 1; i < n + 1; i++) {
//      for (int j = 2; j < n + 1; j++) {
//        if (arrRest[i] == arrRest[j]) {
//          if (arrRest[i] != 0) {
//            caseCntEtc++;
//          }
//        }
//      }
//    }

// 재도전!!!!!
    for (int i = 1; i < n+1; i++) {

      int remainder = (int) (arrSum[i] % m);
      if (remainder == 0) {
        answerCnt++;
      }
      //0인 애들도 컴비네이션 돌려야 하니 추가로 저장! if문 안에 넣으면 안됨! 밖으로..

      arrRest[remainder]++;


    }
//arrRest는 나머지를 인덱스로 ++하는 구조니까 + n아니고 m!
    for (int i = 0; i < m; i++) {
      if (arrRest[i] > 1) {
        answerCnt = answerCnt + (arrRest[i] * (arrRest[i] - 1) / 2);
      }
    }

    System.out.println(answerCnt);
  }
}