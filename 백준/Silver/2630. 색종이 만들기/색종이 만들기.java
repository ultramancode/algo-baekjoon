
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;

    static int blueCount;
    static int whiteCount;
    int[] x = {0, 0, 0, 1};
    int[] y = {0, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countColors(0, 0, N);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    static void countColors(int i, int j, int size) {
        if (isSameColor(i, j, size)) {
            if (map[i][j] == 1) {
                blueCount++;
            } else {
                whiteCount++;
            }
            return;
        }

        int newSize = size / 2;

        countColors(i, j, newSize);
        countColors(i, j + newSize, newSize);
        countColors(i + newSize, j, newSize);
        countColors(i + newSize, j + newSize, newSize);
    }


    static boolean isSameColor(int i, int j, int size) {

        int color = map[i][j];

        for (int k = i; k < i + size; k++) {
            for (int l = j; l < j + size; l++) {
                if (map[k][l] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}

