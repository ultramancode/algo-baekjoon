
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int N = sc.nextInt();
        int[] array = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.fill(dp, 1);


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(array[i] > array[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int maxInt = Arrays.stream(dp).max().getAsInt();
        System.out.println(maxInt);


    }
}
