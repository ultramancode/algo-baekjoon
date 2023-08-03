
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {

    Scanner scanner = new Scanner(System.in);

    //문자로 받고
    String N = scanner.next();

    int[] arr = new int[N.length()];
    for (int i = 0; i < N.length(); i++) {
      arr[i] = Integer.parseInt(N.substring(i, i + 1));
    }

    //선택정렬 직접 구현해보기
    for (int i = 0; i < arr.length; i++) {
      //max.. i로 잡자 조심!
      int max = i;
      for (int j = i + 1; j < arr.length; j++) {

        if (arr[max] < arr[j]) {
          max = j;
        }
      }
      //내림차순이니까 맨 앞에 있는 애보다 맥스가 더 크다면! 위치 바꾸기! i 기준 j 아님!
      if (arr[i] < arr[max]) {
        int temp = arr[i];
        arr[i] = arr[max];
        arr[max] = temp;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }


  }


}



