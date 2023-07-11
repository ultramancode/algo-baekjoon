import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int m = Integer.parseInt(bf.readLine());
    int[] a = new int[n];
    StringTokenizer st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    int lt = 0;
    int rt = 0;
    int cnt = 0;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i+1; j < n; j++) {
        if (a[i] + a[j] == m) {
          cnt++;
        }
      }
    }
    System.out.println(cnt);
  }
}
