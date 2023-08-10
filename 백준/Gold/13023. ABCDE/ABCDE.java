import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static boolean[] visited;
  static ArrayList<Integer>[] arr;
  static boolean answer;

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    //친구관계 여부
    visited = new boolean[N];

    arr = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int s = Integer.parseInt(stringTokenizer.nextToken());
      int e = Integer.parseInt(stringTokenizer.nextToken());
      //양방향.. 방향 없는 노드들이니
      arr[s].add(e);
      arr[e].add(s);
    }

    //노드마다 dfs 실행
    for (int i = 0; i < N; i++) {
      //1은 뎁스.. 뎁스 5면 친구관계니 뎁스 5까지만 돌려야 효율적이니
      DFS(i, 1);
      if (answer) {
        break;
      }

    }
    if (answer) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }

  static void DFS(int now, int depth) {

    if(depth == 5) {
      answer = true;
      return;
    }
    visited[now] = true;

    for (int i : arr[now]){
      if(!visited[i]){
        //갈때마다 뎁스 1씩 추가
        DFS(i, depth+1);
    }
  }//방문했던 노드를 다시 미방문 노드로 변경한다..
    visited[now] = false;
}
}