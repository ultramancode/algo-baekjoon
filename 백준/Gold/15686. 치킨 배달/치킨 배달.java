import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int N;
    static int M;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());


        int[][] city = new int[N][N];


        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                if (city[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (city[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0, new ArrayList<>());
        System.out.println(answer);

    }

    public static void calculateDistance(List<int[]> selectedChickens) {
        int total = 0;
        for (int[] house : houses) {
            int min = Integer.MAX_VALUE;
            for (int[] chiken : selectedChickens) {
                int distance = Math.abs(house[0] - chiken[0]) + Math.abs(house[1] - chiken[1]);
                min = Math.min(min, distance);
            }
            total += min;
        }
        answer = Math.min(answer, total);
    }

    public static void dfs(int depth, int start, List<int[]> selected) {

        if (depth == M) {
            calculateDistance(selected);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            dfs(depth + 1, i + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }
}
