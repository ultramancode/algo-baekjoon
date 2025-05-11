
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] numbers;
    static int[] selected;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[N];
        selected = new int[M];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(numbers);

        dfs(0);
    }
    public static void dfs(int depth) {
        if (depth == M) {
            for (int num : selected) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = numbers[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
