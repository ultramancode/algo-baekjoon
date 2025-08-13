import sys
sys.setrecursionlimit(1_000_000)
input = sys.stdin.readline
n, r, q = map(int, input().split())
graph = [[] for _ in range(n+1)]
size = [0] * (n + 1)
def main():

    for _ in range(n-1):
        u, v = map(int, input().split())
        graph[u].append(v)
        # 무향
        graph[v].append(u)

    dfs(r, 0)

    answer = []

    for _ in range(q):
        sub_u = int(input())
        answer.append(str(size[sub_u]))

    print("\n".join(answer))


def dfs(u: int, p: int) -> None:
    size[u] = 1
    for v in graph[u]:
        # 무향이라 무한반복 방지.. 방금 온 부모 방향
        if v == p:
            continue
        dfs(v, u)
        size[u] += size[v]

if __name__ == "__main__":
    main()



