import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int sum = 1;
    int cnt = 0;
    int startIndex = 1;
    int endIndex = 1;

    while (endIndex <= n) {
      if (sum == n) {
        cnt++;
        endIndex++;
        //++; 뒤에! 순서 조심!
        sum += endIndex;
      } else if (sum > n) {
        sum -= startIndex;
        startIndex++;
      } else {
        endIndex++;
        sum += endIndex;
      }
    }
    System.out.println(cnt);
  }
}