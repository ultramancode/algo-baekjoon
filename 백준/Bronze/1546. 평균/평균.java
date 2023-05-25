import java.util.Scanner;
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int s = sc.nextInt();
    int[] arr = new int[s];

    for (int i = 0; i < s; i++) {
      arr[i] = sc.nextInt();
    }
    long max = 0;
    long sum = 0;
    for (int i = 0; i < s; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
      sum += arr[i];
    }
    System.out.println(sum * 100.0 / max / s);
  }
}

