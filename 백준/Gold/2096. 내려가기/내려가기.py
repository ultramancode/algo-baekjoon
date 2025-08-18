import sys
input = sys.stdin.readline

N = int(input())
a, b, c = map(int, input().split())
max_dp = [a, b, c]
min_dp = [a, b, c]

for _ in range(N-1):
    a, b, c = map(int, input().split())

    new_max = [
        max(max_dp[0], max_dp[1]) + a,
        max(max_dp[0], max_dp[1], max_dp[2]) + b,
        max(max_dp[1], max_dp[2]) + c
    ]

    new_min = [
        min(min_dp[0], min_dp[1]) + a,
        min(min_dp[0], min_dp[1], min_dp[2]) + b,
        min(min_dp[1], min_dp[2]) + c
    ]

    max_dp, min_dp = new_max, new_min

print(max(max_dp), min(min_dp))
