
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M;
    static int N;
    static int[][] map;
    static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        String[] rowStrArray = new String[N];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String rowInput = bufferedReader.readLine();
            char[] rowInputCharArray = rowInput.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < M; j++) {
                map[i][j] = rowInputCharArray[j] - '0';
                stringBuilder.append(map[i][j]);
            }
            rowStrArray[i] = stringBuilder.toString();
        }

        K = Integer.parseInt(bufferedReader.readLine());

        int maxRows = 0;
        for (int i = 0; i < N; i++) {
            String curStr = rowStrArray[i];
            int zeroCnt = 0;
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    zeroCnt++;
                }
            }
            if (zeroCnt <= K && (K - zeroCnt) % 2 == 0) {
                int sameRowCnt = 0;
                for (int j = 0; j < N; j++) {
                    if (rowStrArray[j].equals(curStr)) {
                        sameRowCnt++;
                    }
                }
                maxRows = Math.max(maxRows, sameRowCnt);

            }
        }
        System.out.println(maxRows);
    }
}
