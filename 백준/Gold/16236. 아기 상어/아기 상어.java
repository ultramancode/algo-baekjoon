import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int[][] map;
    static int[][] dist;


    static class Fish {
        int x;
        int y;
        int distance;

        Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        dist = new int[N][N];

        int fishX = 0;
        int fishY = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    fishY = i;
                    fishX = j;
                    map[i][j] = 0;
                }
            }
        }

        int fishLevel = 2;
        int feedCnt = 0;
        int answer = 0;
        while (true) {
            Fish nextFish = findNextFish(fishX, fishY, fishLevel);

            if (nextFish == null) {
                break;
            }

            answer += nextFish.distance;
            fishX = nextFish.x;
            fishY = nextFish.y;

            map[fishY][fishX] = 0;
            feedCnt++;

            if (feedCnt == fishLevel) {
                fishLevel++;
                feedCnt = 0;
            }
        }
        System.out.println(answer);
    }

    static Fish findNextFish(int x, int y, int fishLevel) {
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        dist[y][x] = 0;

        List<Fish> fishList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextX >= dist.length || nextY < 0 || nextY >= dist.length) {
                    continue;
                }
                if (dist[nextY][nextX] != -1) {
                    continue;
                }
                if (map[nextY][nextX] > fishLevel) {
                    continue;
                }

                dist[nextY][nextX] = dist[currentY][currentX] + 1;
                queue.add(new int[]{nextX, nextY});

                if (map[nextY][nextX] != 0 && map[nextY][nextX] < fishLevel) {
                    fishList.add(new Fish(nextX, nextY, dist[nextY][nextX]));
                }
            }
        }
        if (fishList.isEmpty()) {
            return null;
        }
        fishList.sort(
                (fish1, fish2) -> {
                    if (fish1.distance != fish2.distance) {
                        return fish1.distance - fish2.distance;
                    }
                    if (fish1.y != fish2.y) {
                        return fish1.y - fish2.y;
                    }
                    return fish1.x - fish2.x;
                });
        return fishList.get(0);
    }
}