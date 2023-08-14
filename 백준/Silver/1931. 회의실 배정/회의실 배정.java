import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.AllPermission;
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
import javax.naming.LinkLoopException;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(bufferedReader.readLine());
    //0에는 끝지점, 1에는 시작지점. (정렬 용이하게 하기 위해 종료부터)
    int[][] arr = new int[N][2];


    for (int i = 0; i < N; i++) {

      //정렬 용이하게.. 종료점 기준으로 오름차순할거고 만약 종료시점 같은 경우 시작점 기준으로 오름차순
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int start = Integer.parseInt(stringTokenizer.nextToken());
      int end = Integer.parseInt(stringTokenizer.nextToken());
      arr[i][0] = end;
      arr[i][1] = start;
    }

    int count = 0;
    int endTime = 0;
    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if( o1[0] == o2[0]){
          return o1[1] - o2[1];
        }else {
          return o1[0] - o2[0];
        }
      }
    });
    for (int i = 0; i <N; i++) {
      //종료시점이 시작시점보다 작은 경우
      if(endTime <= arr[i][1]){
        endTime = arr[i][0];
        count++;
      }
    }
    System.out.println(count);



}

}

