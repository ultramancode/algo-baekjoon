import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        int[] zero = new int[41];
        int[] one = new int[41];

        // 0 호출 시
        zero[0] = 1; 
        one[0] = 0;

        // 1 호출
        zero[1] = 0; 
        one[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1] + one[i-2];
        }

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            System.out.println(zero[n] + " " + one[n]);
        }
    }
}
