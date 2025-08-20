import sys
import heapq
input = sys.stdin.readline

T = int(input())
for i in range(T):
    k = int(input())
    max_heap = []
    min_heap = []
    visited = [False] * k
    for j in range(k):
        operation, number = input().split()
        number = int(number)
        if operation == "I":
            heapq.heappush(max_heap, (-number, j))
            heapq.heappush(min_heap, (number, j))
            visited[j] = True
        if operation == "D":
            if number == 1:
            # 연속으로 죽은값일 수 있으니 단순 if가 아니라 while문으로
            # min, max 힙 둘 중 하나만 제거하니 visited로 판별 중
                while max_heap and not visited[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                if max_heap:
                    visited[max_heap[0][1]] = False
                    heapq.heappop(max_heap)
            elif number == -1:
                while min_heap and not visited[min_heap[0][1]]:
                    heapq.heappop(min_heap)
                if min_heap:
                    visited[min_heap[0][1]] = False
                    heapq.heappop(min_heap)
    while min_heap and not visited[min_heap[0][1]]:
        heapq.heappop(min_heap)
    while max_heap and not visited[max_heap[0][1]]:
        heapq.heappop(max_heap)
    if not min_heap or not max_heap:
        print("EMPTY")
    else:
        print(-max_heap[0][0], min_heap[0][0])



