import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] lines = new long[K];
        long maxLength = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            long nowNum = Long.parseLong(st.nextToken());
            if (nowNum > maxLength) {
                maxLength = nowNum;
            }
            lines[i] = nowNum;
        }

        long leftNum = 1;
        long rightNum = maxLength;
        long answer = 0;

        while (leftNum <= rightNum) {
            long mid = (leftNum + rightNum) / 2;

            long count = 0;
            for (long line : lines) {
                count += line / mid;
            }

            if (count >= N) {
                answer = mid;
                leftNum = mid+1;
            } else {
                rightNum = mid-1;
            }
        }
        System.out.println(answer);
    }
}
