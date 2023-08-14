import java.awt.SystemTray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    Scanner scanner =new Scanner(System.in);

    String query = scanner.nextLine();

    String[] arr = query.split("-");

    int answer = 0;
    for (int i = 0; i < arr.length; i++) {
     int count = customSum(arr[i]);

     if( i==0) {
       answer += count;
     }else {
       answer -= count;
     }
    }
    System.out.println(answer);



  }

  private static int customSum(String num) {

    int sum = 0;
    //그냥 +는 안되네.. 이럴 땐 [] 로 묶기
    String[] temp = num.split("[+]");

    for (int i = 0; i <temp.length; i++) {
      sum += Integer.parseInt(temp[i]);
    }

    return sum;


  }

}

