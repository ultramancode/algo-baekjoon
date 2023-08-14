import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.naming.LinkLoopException;

public class Main {

  public static void main(String[] args) throws IOException {

    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int K = scanner.nextInt();

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = scanner.nextInt();
    }
//동전 갯수
    int count = 0;
//그리디(문제 조건에서 배수라고 했으니) 
//N-1부터 0까지 내려가면서
    for (int i = N - 1; i >= 0; i--) {
      if(K >= arr[i]){
        count += K/arr[i];
        K = K % arr[i];
    }
  }
    System.out.println(count);


}
}

