import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int K = sc.nextInt();

        int[] weights = new int[N];
        int[] values = new int[N];
        
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        
        int[] dp = new int[K + 1];
        
        for (int i = 0; i < N; i++) {
            for (int j = K; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        System.out.println(dp[K]);
    }
}
