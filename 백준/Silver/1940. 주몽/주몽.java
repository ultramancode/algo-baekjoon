import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
    int cnt = 0;
    Arrays.sort(a);
    int i = 0;
    int j = n-1;
    while (i < j) {
      int sum = a[i] + a[j];
      if (sum < m) {
        i++;
      } else if (sum > m) {
        j--;
      } else {
        i++;
        j--;
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
