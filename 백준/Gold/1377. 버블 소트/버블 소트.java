
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(bufferedReader.readLine());
    CustomData[] arr = new CustomData[N];
    for (int i = 0; i < N; i++) {
      arr[i] = new CustomData(Integer.parseInt(bufferedReader.readLine()), i);
    }

    Arrays.sort(arr);  // nlogn

    int Max = 0;
    for (int i = 0; i < N; i++) {
      if (Max < arr[i].index - i) { //정렬전인덱스-정렬후인덱스 계산의 최댓값(기존 인덱스와,밸류 저장해놨으니)
        Max = arr[i].index - i;
      }
    }
    System.out.println(Max + 1);
  }

  //밸류 기준으로 정렬.. implemets해서 설정해주는 것 잊지말자.. 안하면 에러 뜸
  static class CustomData implements Comparable<CustomData> {

    public int value;
    public int index;

    public CustomData(int value, int index) {
//        super();
      this.value = value;
      this.index = index;
    }

    @Override
    public int compareTo(CustomData o) {
      return this.value - o.value; //value 기준 오름차순 정렬
    }
  }
}



