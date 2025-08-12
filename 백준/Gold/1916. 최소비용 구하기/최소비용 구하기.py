import sys
import heapq
input = sys.stdin.readline

def main():
    n = int(input())
    m = int(input())

    # 1부터 쓸거니 n+1
    course = [[] for _ in range(n+1)]

    for _ in range(m):
        u, v, w = map(int, input().split())
        course[u].append((v, w))

    start, end = map(int, input().split())
    inf = 10**18
    dist = [inf]*(n+1)
    dist[start] = 0

    # (누적 비용,현재 노드)
    pq = [(0, start)]
    while pq:
        sum_cost, u = heapq.heappop(pq)
        if sum_cost > dist[u]:
            continue
        if u == end:
            break
        for v, w in course[u]:
            new_cost = sum_cost + w
            if new_cost < dist[v]:
                dist[v] = new_cost
                heapq.heappush(pq, (new_cost, v))

    print(dist[end])

if __name__ == "__main__":
    main()
