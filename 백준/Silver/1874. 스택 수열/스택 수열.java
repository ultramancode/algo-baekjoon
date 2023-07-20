import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {

    //한줄에 하나씩 입력 받으니까 그냥 스캐너.. 버퍼드리더는 한줄 통으로 받으니..
    Scanner sc = new Scanner(System.in);
    //출력 초과 발생.. Flush 전에 버퍼 차버리면 출력 초과 뜨는듯..
//    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer stringBuffer = new StringBuffer();
    int n = sc.nextInt();

    boolean result = true;
    Stack<Integer> stack = new Stack<>();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int num = 1; //오름차순
    for (int i = 0; i < n; i++) {
      int su = arr[i];
      if (su >= num) {
        while (su >= num) {
          stack.push(num++);
//          bufferedWriter.write("+\n");
          stringBuffer.append("+\n");
        }
        stack.pop();
//        bufferedWriter.write("-\n");
        stringBuffer.append("-\n");

      } else {
        int upNum = stack.pop();
        if (upNum > su) {
          System.out.println("NO");
          result = false;
          break;
        } else {
//          bufferedWriter.write("-\n");
          stringBuffer.append("-\n");

        }
      }
    }
    if (result) {
//      bufferedWriter.flush();
      System.out.println(stringBuffer.toString());

    }
  }
}