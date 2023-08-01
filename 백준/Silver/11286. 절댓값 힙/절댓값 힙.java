import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
        (o1, o2) -> {
          int absFirst = Math.abs(o1);
          int absSecond = Math.abs(o2);
          //절대값이 같은 경우 작은 수 우선 정렬
          if (absFirst == absSecond) {
            return (o1 > o2) ? 1 : -1;
            //절대값 다른 경우 절대값 기준 오름차순
          } else {
            return absFirst - absSecond;
          }
        }
    );

    for (int i = 0; i < N; i++) {
      int request = Integer.parseInt(bufferedReader.readLine());
      if (request == 0 && priorityQueue.isEmpty()) {
        System.out.println("0");
      } else if (request == 0) {
        System.out.println(priorityQueue.poll());
      } else {
        priorityQueue.add(request);
      }

    }
  }
}