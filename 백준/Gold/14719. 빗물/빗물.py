import sys
input = sys.stdin.readline

def main():
    H, W = map(int, input().split())
    heights = list(map(int, input().split()))

    left_max = [0] * W
    right_max = [0] * W

    # 왼쪽 최대
    left_max[0] = heights[0]
    for i in range(1,W):
        left_max[i] = max(left_max[i-1], heights[i])

    # 오른쪽 최대
    right_max[W-1] = heights[W-1]
    for i in range(W-2,-1,-1):
        right_max[i] = max(right_max[i+1], heights[i])

    answer = 0
    for i in range(W):
        answer += min(left_max[i], right_max[i]) - heights[i]

    print(answer)


if __name__ == "__main__":
    main()