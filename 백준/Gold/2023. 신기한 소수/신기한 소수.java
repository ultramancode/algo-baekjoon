import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static StringBuilder stringBuilder = new StringBuilder();

  public static void main(String[] args) throws IOException {
//n이 8이니 dfs돌리자. 최대값이 작으니
    Scanner scanner = new Scanner(System.in);
    N = scanner.nextInt();
    // 1~10중에 소수는 2,3,5,7이니 거기부터 dfs..! 좀 더 메모리 최적화를 위해..!
    // 자릿수 1부터 쭉쭉
    dfs(2, 1);
    dfs(3, 1);
    dfs(5, 1);
    dfs(7, 1);

    System.out.println(stringBuilder.toString());
  }

  private static void dfs(int number, int nowN) {
    if (nowN == N) {
      if (isPrime(number)) {
        stringBuilder.append(number).append("\n");
        return;
      }
    }
    for (int i = 1; i < 10; i++) {
      //무조건 소수 아닌 애들 일단 pass
//      if (i % 2 == 0) {
//        continue;
//      }
      // 값 증가시키면서 소수면 다시 재귀 돌리기
      if (isPrime(number * 10 + i)) {
        dfs((number * 10 + i), nowN + 1);
      }
    }
  }


  private static boolean isPrime(int n) {
    if (n == 2) {
      return true;
    }
    //제곱근까지만 확인하면 됨
    //
    for (int i = 2; i < Math.sqrt(n)+1; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}


