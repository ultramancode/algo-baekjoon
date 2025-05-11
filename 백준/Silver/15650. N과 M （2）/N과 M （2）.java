
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] selected;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M];

        dfs(1,0);

    }
    static void dfs(int start, int depth){
        if(depth == M){
            for(int num : selected){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[depth] = i;
            dfs(i+1, depth+1);
        }
    }
}
