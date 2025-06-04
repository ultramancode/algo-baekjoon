
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (right <= N) {
            if (sum >= S) {
                minLen = Math.min(minLen, right - left);
                sum -= arr[left];
                left++;
            // right가 N이고 위에 if문에서 먼저 left만 왔다갔다하며 처리하는 케이스 고려..
            // 단순하게 while문에서 right가 N일 때 끝내면 위 케이스 고려 못하니
            } else if(right == N){
                break;
            } else {
                sum += arr[right];
                right++;
            }
        }
        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
