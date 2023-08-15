import java.awt.SystemTray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    Scanner scanner = new Scanner(System.in);

    long N = scanner.nextLong();
    long M = scanner.nextLong();

    long[] arr = new long[10000001];

    for (int i = 2; i < arr.length; i++) {
      arr[i] = i;
    }

    //제곱근까지만 구하면 충분함. 안전하게 <= 으로
    for (int i = 2; i <= Math.sqrt(arr.length); i++) {

      //이미 처리한 거는 0으로 해줘서 시간복잡도 줄여주자! 이를 통해서 이중for문이지만 n제곱이 아니라 훨씬 적게걸 림
      if (arr[i] == 0) {
        continue;
      }

      //i의 배수 지우기 , j = j+i !!, i는 놔둬야하니까 i+i부터!
      for (int j = i + i; j < arr.length; j = j + i) {
        arr[j] = 0;
      }
    }
    //거의 소수 구하기
    int count = 0;

    for (int i = 2; i < 10000001; i++) {
      if (arr[i] != 0) {
        long temp = arr[i];
        while ((double)arr[i] <= (double)M / (double)temp) {
          if ((double)arr[i] >= (double)N / (double)temp) {
            count++;
          }
          temp = temp * arr[i];
        }
      }
    }
    System.out.println(count);

  }
}





