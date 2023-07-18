import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //최솟값을 공백으로 구분해서 순서대로 출력하라고 했으니...
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int L = Integer.parseInt(stringTokenizer.nextToken());

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    //500만까지 받으니 nlog(n) 시간복잡도의 정렬은 안됨. 덱으로..
    Deque<Node> deque = new LinkedList<>();

    for (int i = 0; i < N; i++) {

      int now = Integer.parseInt(stringTokenizer.nextToken());

      //새로운 값 들어올 때마다 그 값보다 큰 기존 값들 제거
      while(!deque.isEmpty() && deque.getLast().value > now){
        deque.removeLast();
      }

      deque.addLast(new Node(i, now));

      //윈도우 범위 벗어난 값을 덱에서 제거

      if((i - L) >= deque.getFirst().index){
        deque.removeFirst();
      }

      bufferedWriter.write(deque.getFirst().value + " ");
    }
    bufferedWriter.flush();
    bufferedWriter.close();
  }
  static class Node {
    int index;
    int value;

    public Node(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
}