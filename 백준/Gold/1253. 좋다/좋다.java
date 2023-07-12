import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine());

    int[] m = new int[n];

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    for (int i = 0; i < n; i++) {
      m[i] = Integer.parseInt(stringTokenizer.nextToken());
    }
    Arrays.sort(m);

    int count = 0;

    for (int k = 0; k < n; k++) {
      int startIndex = 0;
      int endIndex = n - 1;
      int findNum = m[k];
      while (startIndex < endIndex) {
        int sum = m[startIndex] + m[endIndex]; // 아... 바로 startIndex+endIndex하다가 시간 날렸네 ..

        if (sum < findNum) {
          startIndex++;
        } else if (sum > findNum) {
          endIndex--;
        } else if (sum == findNum) {
          if (startIndex != k && endIndex != k) {
            count++;
            break;
          }
          else if (startIndex == k) {
            startIndex++;
          }
          else if (endIndex == k) {
            endIndex--;
          }
        }
      }

    }
    System.out.println(count);
  }
}
