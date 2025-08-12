import sys
from collections import deque

input = sys.stdin.readline

def main():
    m, n, h = map(int, input().split())
    tomato_map = []
    q = deque()

    #안 익은 애들
    unripe_cnt = 0

    for _ in range(h):
        layer = []
        for _ in range(n):
            row = list(map(int, input().split()))
            layer.append(row)
        tomato_map.append(layer)

    for z in range(h):
        for y in range(n):
            for x in range(m):
                visited = tomato_map[z][y][x]
                if visited == 1:
                    q.append((z, y, x))
                elif visited == 0:
                    unripe_cnt += 1

    if unripe_cnt == 0:
        print(0)
        return

    dx = (0,0,-1,1,0,0)
    dy = (1,-1,0,0,0,0)
    dz = (0,0,0,0,1,-1)

    #bfs
    while q:
        for _ in range(len(q)):
            z, y, x = q.popleft()
            # 상하좌우+위아래
            for d in range(6):
                nx = x + dx[d]
                ny = y + dy[d]
                nz = z + dz[d]

                if 0 <= nx < m and 0<= ny <n and 0 <= nz < h:
                    if tomato_map[nz][ny][nx] == 0:
                        tomato_map[nz][ny][nx] = tomato_map[z][y][x] +1
                        q.append((nz, ny, nx))

    #마무리
    days = 0
    for z in range(h):
        for y in range(n):
            for x in range(m):
                if tomato_map[z][y][x] == 0:
                    print(-1)
                    return
                else:
                    days = max(tomato_map[z][y][x], days)

    #익은 토마토 첫날 1이니 빼기
    print(days-1)


if __name__ == "__main__":
    main()
