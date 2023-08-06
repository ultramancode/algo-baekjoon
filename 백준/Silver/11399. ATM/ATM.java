
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(bufferedReader.readLine());

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int[] arr = new int[N];
    int[] sumArr = new int[N];

    for (int i = 0; i < N; i++) {

      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    //Arrays.sort 안쓰고 삽입 정렬 연습용으로 구현해서 문제 풀어봄

    for (int i = 1; i < N; i++) {
      int insertPoint = i;
      int insertValue = arr[i];
      //i-1, >=0 , j--
      //현재 자리 바로 앞칸부터 -1씩
      for (int j = i - 1; j >= 0; j--) {

        //현재 탐색하는 자리 j가 나(i)보다 작으면 +1해서 삽입자리 저장
        if (arr[j] < arr[i]) {
          insertPoint = j + 1;
          break;
        }
        //만약에 break안하고 j가 0까지 왔다는 건 끝까지 탐색했다는 것. 즉 지금 i가 제일 작은애라는 것
        if (j == 0) {
          insertPoint = 0;
        }
      }
      //삽입 포인트 이후 애들은 한칸씩 뒤로 밀기
      for (int j = i; j > insertPoint; j--) {
        arr[j] = arr[j - 1];
      }
      arr[insertPoint] = insertValue;
    }

    //0번째는 넣어줘야 밑에 합배열 for문으로 채울 수 있으니
    sumArr[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      sumArr[i] = sumArr[i - 1] + arr[i];
    }

    int sum = 0;

    for (int i = 0; i < N; i++) {
      sum += sumArr[i];
    }

    System.out.println(sum);


  }
}


