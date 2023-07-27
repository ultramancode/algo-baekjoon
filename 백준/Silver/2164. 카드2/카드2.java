import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

Scanner scanner = new Scanner(System.in);

int N = scanner.nextInt();

Queue<Integer> queue = new LinkedList<>();

// <= 조심.. < 습관성..
    for (int i = 1; i <= N; i++) {

      queue.add(i);

    }

while(queue.size()>1){
  queue.poll();
  queue.add(queue.poll());
}
int ans = queue.poll();
    System.out.println(ans);

  }

}