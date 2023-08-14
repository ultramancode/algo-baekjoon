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

    int M = scanner.nextInt();
    int N = scanner.nextInt();

    int[] arr = new int[N + 1];

    for (int i = 1; i < N + 1; i++) {
      arr[i] = i;
    }

    //제곱근까지만 구하면 충분함. 안전하게 <= 으로
    for (int i = 2; i <= Math.sqrt(N); i++) {

      //이미 처리한 거는 0으로 해줘서 시간복잡도 줄여주자! 이를 통해서 이중for문이지만 n제곱이 아니라 훨씬 적게걸 림
      if (arr[i] == 0) {
        continue;
      }

      //i의 배수 지우기 , j = j+i !!, i는 놔둬야하니까 i+i부터!
      for (int j = i + i; j < N + 1; j = j + i) {
        arr[j] = 0;
      }
    }
    for (int i = M; i < N + 1; i++) {
      if (arr[i] != 0 && arr[i] != 1) {
        System.out.println(arr[i]);
      }
    }


  }
}





