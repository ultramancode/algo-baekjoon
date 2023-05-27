import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int firstNo = Integer.parseInt(stringTokenizer.nextToken());
    int quizNo = Integer.parseInt(stringTokenizer.nextToken());

    long[] arr = new long[firstNo + 1];
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 1; i < firstNo + 1; i++) {

      arr[i] = arr[i - 1] + Long.parseLong(stringTokenizer.nextToken());

    }

    for (int i = 0; i < quizNo; i++) {
      stringTokenizer = new StringTokenizer(
          bufferedReader.readLine()); //for문 안에 둬야 계속 이어지며 답구하는구나..
      int j = Integer.parseInt(stringTokenizer.nextToken());
      int k = Integer.parseInt(stringTokenizer.nextToken());
      System.out.println(arr[k] - arr[j - 1]); //k가 앞임
    }
  }
}