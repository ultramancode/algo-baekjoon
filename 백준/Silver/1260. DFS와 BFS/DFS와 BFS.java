import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


  static ArrayList<Integer>[] arrayList;
  private static BufferedReader bufferedReader;

  static boolean[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());
    int V = Integer.parseInt(stringTokenizer.nextToken());

    arrayList = new ArrayList[N + 1];
    visited = new boolean[N + 1];
    //자꾸 빼먹네.. 초기화도 포문으로.. 어레이리스트 안에 어레이리스트
    for (int i = 1; i < N + 1; i++) {
      arrayList[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int s = Integer.parseInt(stringTokenizer.nextToken());
      int e = Integer.parseInt(stringTokenizer.nextToken());

      arrayList[s].add(e);
      arrayList[e].add(s);
    }

    for (int i = 1; i < N + 1; i++) {
      Collections.sort(arrayList[i]);
    }

    DFS(V);
    System.out.println();
    //초기화 새로 해주자... 왜 자꾸 이상하게 되나 했네..
    visited = new boolean[N+1];
    BFS(V);
    System.out.println();

  }

  private static void BFS(int node) {
//    System.out.print(node + " ");
    Queue<Integer> queue = new LinkedList<Integer>();
    //여기도 true 먼저 해주는게 안정적일까 흠
    visited[node] = true;
    queue.add(node);
    //큐 비울 때까지 반복
    while (!queue.isEmpty()) {
      int nowNode = queue.poll();
      System.out.print(nowNode + " ");
      for (int i : arrayList[nowNode]) {
        if (!visited[i]) {
          // i가 큐에 추가되는 순간부터 방문한 것으로 표시해서
          // 큐에 추가된 노드들이 중복해서 처리하지 않도록!
          visited[i] = true;
          queue.add(i);

        }

      }
    }

  }

  static void DFS(int node) {
    System.out.print(node + " ");
    if(visited[node]){
      return;
    }
    visited[node] = true;
    for (int i : arrayList[node]) {
      if (!visited[i]) {
        DFS(i);
      }
    }

  }
}