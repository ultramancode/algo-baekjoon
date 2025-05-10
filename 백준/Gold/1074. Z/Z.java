
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.close();

        System.out.println(zCount(N,r,c));

    }


    static int zCount(int N, int r, int c) {
        int count = 0;

        while(N>0) {
            int size = (int) Math.pow(2, N - 1);
            int area = size * size;
            // 1사분면
            if (r < size && c < size) {
            }
            // 2사분면
            else if (r < size && c >= size) {
                count += area;
                c -= size;
            }
            // 3사분면
            else if (r >= size && c < size) {
                count += area * 2;
                r -= size;
            }
            // 4사분면
            else if (r >= size && c >= size) {
                count += area * 3;
                r -= size;
                c -= size;
            }
            N--;
        }
        return count;
    }
}
