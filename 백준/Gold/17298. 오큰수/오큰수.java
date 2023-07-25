import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(bufferedReader.readLine());
    int[] arr = new int[N];
    //위치 신경 . .
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < N; i++) {

      //스택 비어있으면 일단 넣고, 스택의 탑부분이 현재 arr[i]값보다 낮을때까지 반복
      while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
        //오큰수 있는 애들이니까 pop해서 스택에서 비우고 오큰수값을 배열에 넣어줌
        arr[stack.pop()] = arr[i];
      }
      //비어 있는 경우 + 오큰수 못구한 애들 일단 push
      stack.push(i);
    }

    //스택에 남아있는 애들(오큰수 구하지 못한 애들) -1 처리
    while(!stack.isEmpty()){

      arr[stack.pop()] = -1;
    }

    for (int num : arr) {
      bufferedWriter.write(num + " ");
    }
    bufferedWriter.flush();
    bufferedWriter.close();
  }

}