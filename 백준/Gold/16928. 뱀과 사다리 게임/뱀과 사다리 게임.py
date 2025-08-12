import sys
from collections import deque

input = sys.stdin.readline

def main():
    n, m = map(int, input().split())
    move = list(range(101))

    for _ in range(n):
        x, y = map(int, input().split())
        move[x] = y

    for _ in range(m):
        u, v = map(int, input().split())
        move[u] = v

    # bfs
    dist = [-1]*101
    q = deque([1])
    # 1번칸은 시작점이니 0번 굴림
    dist[1] = 0

    while q:
        cur = q.popleft()
        if cur == 100:
            print(dist[cur])
            return
        for dice in range(1,7):
            next = cur + dice
            # 100 넘어가면 무효니까 패스
            if next > 100:
                continue
            next = move[next]
            if dist[next] == -1:
                dist[next] = dist[cur] + 1
                q.append(next)

if __name__ == "__main__":
    main()
