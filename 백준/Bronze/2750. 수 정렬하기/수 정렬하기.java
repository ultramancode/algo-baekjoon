
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(bufferedReader.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(bufferedReader.readLine());
    }

    for (int i = 0; i < N - 1; i++) {
      //i는 놔두고 j랑 j+1로
      for (int j = 0; j < N - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }

      }
    }
    for (int i = 0; i < N; i++) {
      System.out.println(arr[i]);


    }

  }
}

