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

  static int N;
  static int M;

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(bufferedReader.readLine());

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int[] arrN = new int[N];
    for (int i = 0; i < N; i++) {
      arrN[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    M = Integer.parseInt(bufferedReader.readLine());
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int[] arrM = new int[M];
    for (int i = 0; i < M; i++) {
      arrM[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    Arrays.sort(arrN);

    for (int i = 0; i < M; i++) {
      boolean find = false;

      int start = 0;
      int end = arrN.length - 1;
      while (start <= end) {

        int midIndex = (start + end) / 2;
        int midValue = arrN[midIndex];

        if (midValue > arrM[i]) {
          end = midIndex - 1;
        } else if (midValue < arrM[i]) {
          start = midIndex + 1;
        } else {
          find = true;
        //아 break; 빼먹지말자.. !!
          break;
        }


      }
      if (find) {System.out.println(1);};
      if (!find) {
        System.out.println(0);}
    }


  }
}

