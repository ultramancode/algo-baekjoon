
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = N - 1;
        int nearZero = Integer.MAX_VALUE;
        int answerFirst = 0;
        int answerSecond = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < nearZero) {
                nearZero = Math.abs(sum);
                answerFirst = arr[left];
                answerSecond = arr[right];
            }
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answerFirst + " " + answerSecond);
    }
}
