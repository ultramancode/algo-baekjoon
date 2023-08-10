import java.awt.PrintGraphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static boolean visited[]; //위치 흠
  static ArrayList<Integer>[] arr;

  public static void main(String[] args) throws IOException {

    //방문 기록 저장하는 배열
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    visited = new boolean[N+1]; //0번 인덱스 사용하면 헷갈릴 것 같으니 1번부터 하기 위해
    arr = new ArrayList[N+1];
    //안헷갈리려고 1번부터
    //어레이리스트 안에 있는 어레이리스트 초기화(인접리스트)
    for (int i = 1; i < N+1; i++) {
      arr[i] = new ArrayList<Integer>();
    }
    //인접리스트에 m개 데이터 들어 간다고 했으니 m번 반복
    for (int i = 0; i < M ; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int s = Integer.parseInt(stringTokenizer.nextToken());
      int e = Integer.parseInt(stringTokenizer.nextToken());

      //시작점에서 종료점, 종료점에서 시작점 갈 수 있게 양쪽 방향으로 add
      //방향성 없으니..
      arr[s].add(e);
      arr[e].add(s);
    }
    int count = 0;
    //생각없이 0,N으로하면 널포인터익셉션 발생, 위에서 1,n+1로 설정 했음!
    for (int i = 1; i <N+1; i++) {
      //방문하지 않은 노드면 ++하고 dfs ㄱㄱ
      if(!visited[i]){
        count ++;
        DFS(i);
      }
    }
    System.out.println(count);
  }
  static void DFS(int v) {
    if(visited[v]){
      return;
    }
    //리턴 안됐으면 방문노드 아니니까 트루로 바꾸고
    visited[v] = true;
    //그리고 현재 노드의 연결 노드 중 방문하지 않은 애들은 다시 dfs
    for (int i : arr[v]) {
      //탐색하지 않은 노드는 다시 dfs
      if(!visited[i]) {
        DFS(i);
      }
    }
  }
}