
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static ArrayList<Edge>[] arrayList;
  static boolean[] visited;
  static int[] distance;

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bufferedReader.readLine());

    arrayList = new ArrayList[N+1];
    for (int i = 1; i < N+1; i++) {
      arrayList[i] = new ArrayList<Edge>();
    }


    for (int i = 1; i < N+1; i++) {
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
int start = Integer.parseInt(stringTokenizer.nextToken());
      while (stringTokenizer.hasMoreTokens()) {
        int end = Integer.parseInt(stringTokenizer.nextToken());
        if (end == -1) {
          break;
        }
        int distance = Integer.parseInt(stringTokenizer.nextToken());
        Edge edge = new Edge(end, distance);
        arrayList[start].add(edge);
      }
    }

    distance = new int[N+1];
    visited = new boolean[N+1];

BFS(1);
int max = 1;
    for (int i = 0; i < N+1; i++) {
      if(distance[max] < distance[i]){
        max = i;
      }
    }
distance = new int[N+1];
visited = new boolean[N+1];

BFS(max);
Arrays.sort(distance);
    System.out.println(distance[N]);
  }

  private static class Edge {

    int index;
    int distance;

    public Edge(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }
  }

  private static void BFS(int index) {

    if (visited[index]) {
      return;
    }
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(index);
    visited[index] = true;
    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (Edge edge : arrayList[now]) {
        int i = edge.index;
        int d = edge.distance;
        if (!visited[i]) {
          visited[i] = true;
          queue.add(i);
          //아 진짜.. 여기 i..넣어야지 왜 d를.. 조심하자
          distance[i] = distance[now] + d;
        }
      }

    }


  }
}





