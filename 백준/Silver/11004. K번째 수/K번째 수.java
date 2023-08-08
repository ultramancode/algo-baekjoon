
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
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());

    int K = Integer.parseInt(stringTokenizer.nextToken());

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    //Arrays.sort 안쓰고 퀵정렬 연습용으로 구현
    quickSort(arr, 0, N - 1, K - 1);
    System.out.println(arr[K - 1]);
  }


  //퀵소트 실행(퀵소트 + k번째 수 찾을 거니까 재귀로 계속 돌려야함)
//k번째 데이터  출력
  public static void quickSort(int[] arr, int left, int right, int K) {

    if (left < right) {

      int pivot = partition(arr, left, right);
      //k번째 수
      if (pivot == K) {
        return;
      } else if (pivot > K) {
        quickSort(arr, left, pivot - 1, K);
      } else {
        quickSort(arr, pivot + 1, right, K);
      }

    }
  }


  public static int partition(int[] arr, int left, int right) {

    if (left + 1 == right) {
      if (arr[left] > arr[right]) {
        swap(arr, left, right);
      }
      return right;
    }

    int M = (left + right) / 2;
    swap(arr, left, M);
    int pivot = arr[left];
    int i = left + 1;
    int j = right;

    while (i <= j) {
      while (pivot < arr[j] && j > 0) {
        j--;
      }

      while (pivot > arr[i] && i < arr.length - 1) {
        i++;
      }
      //멈췄는데 i<=j면 스왑해야지
      if (i <= j) {
        swap(arr, i++, j--);
      }
    }
    //j는 현재 Pivot보다 작은 값 중 제일 오른쪽값 인덱스
    arr[left] = arr[j];
    arr[j] = pivot;
    return j;
  }

  public static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}



