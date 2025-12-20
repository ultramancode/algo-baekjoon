import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] numbers = new int[N];
        int[] count = new int[8001];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            numbers[i] = num;
            sum += num;
            count[num + 4000]++;
        }

        Arrays.sort(numbers);

        int avg = (int) Math.round((double) sum / N);
        int mid = numbers[N / 2];
        int maxFreq = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] > maxFreq) {
                maxFreq = count[i];
            }
        }

        int maxFreqIndex = 0;
        boolean second = false;
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxFreq) {
                if (!second) {
                    maxFreqIndex = i - 4000;
                    second = true;
                } else {
                    maxFreqIndex = i - 4000;
                    break;
                }
            }
        }

        int range = numbers[N - 1] - numbers[0];

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(maxFreqIndex);
        System.out.println(range);
    }
}
